package io.github.hosseinkarami_dev.near.rpc.generator.generators

import io.github.hosseinkarami_dev.near.rpc.generator.SealedInfo
import io.github.hosseinkarami_dev.near.rpc.generator.VariantInfo
import java.io.File

object SerializerGenerator {
    @JvmStatic
    fun generateFromSealedInfos(
        sealedInfos: List<SealedInfo>,
        serializerPackage: String,
        output: File
    ) {
        if (sealedInfos.isEmpty()) return

        for (info in sealedInfos) {
            try {
                val (fileName, content) = generateSealedClassSerializerContent(info, serializerPackage)
                val packagePath = serializerPackage.replace('.', File.separatorChar)
                val dir = File(output, packagePath)
                if (!dir.exists()) dir.mkdirs()

                val outFile = File(dir, fileName)
                outFile.writeText(content)

            } catch (ex: Exception) {
                System.err.println("Failed generating serializer for ${info.className}: ${ex.message}")
                throw RuntimeException("Generation failed for ${info.className}", ex)
            }
        }
    }

    private fun generateSealedClassSerializerContent(info: SealedInfo, serializerPackage: String): Pair<String, String> {
        val modelsPkg = info.packageName
        val clsName = info.className
        val serializerName = "${clsName}Serializer"
        val fileName = "$serializerName.kt"

        val imports = mutableSetOf<String>().apply {
            add("kotlinx.serialization.KSerializer")
            add("kotlinx.serialization.encoding.Decoder")
            add("kotlinx.serialization.encoding.Encoder")
            add("kotlinx.serialization.serializer")
            add("kotlinx.serialization.builtins.ListSerializer")
            add("kotlinx.serialization.builtins.MapSerializer")
            add("io.github.hosseinkarami_dev.near.rpc.serializers.BlindUnionSerializer")
            add("io.github.hosseinkarami_dev.near.rpc.serializers.Variant")
            add("io.github.hosseinkarami_dev.near.rpc.serializers.VariantKind")
        }

        val sb = StringBuilder()
        sb.appendLine("package $serializerPackage")
        sb.appendLine()
        imports.sorted().forEach { sb.appendLine("import $it") }
        sb.appendLine("import $modelsPkg.$clsName")
        sb.appendLine()

        sb.appendLine("object $serializerName : KSerializer<$clsName> {")
        sb.appendLine("    private val union: BlindUnionSerializer<$clsName> = BlindUnionSerializer(")
        sb.appendLine("        serialName = \"$modelsPkg.$clsName\",")
        sb.appendLine("        variants = listOf(")

        val variantLines = mutableListOf<String>()
        for (v in info.variants) {
            val variantClass = "$modelsPkg.$clsName.${v.name}"
            val isObjectSingleton = v.kind == VariantInfo.Kind.OBJECT && v.props.isEmpty()
            val isValue = v.props.size == 1 && v.props[0].name == "value"
            val isWrappedSingle = v.props.size == 1 && v.props[0].serialName == v.serialName
            val kind = when {
                isObjectSingleton -> "VariantKind.OBJECT"
                isValue -> "VariantKind.VALUE"
                isWrappedSingle -> "VariantKind.WRAPPED"
                else -> "VariantKind.DEFAULT"
            }
            val isInstanceExpr = "{ it is $variantClass }"
            val fullSer = "serializer<$variantClass>() as KSerializer<Any?>"
            val line = StringBuilder()
            line.append("            Variant(")
            line.append("serialName = \"${v.serialName}\", ")
            line.append("kind = $kind, ")
            line.append("isInstance = $isInstanceExpr, ")
            line.append("fullSerializer = $fullSer")
            if (kind == "VariantKind.OBJECT") {
            line.append(", objectInstance = $variantClass")
            } else if (kind == "VariantKind.VALUE" || kind == "VariantKind.WRAPPED") {
                val p = v.props[0]
                val valueSer = serializerExpr(p.type, modelsPkg, clsName, v.name) + " as KSerializer<Any?>"
                val castType = fqTypeWithNullability(p.type, modelsPkg, clsName, v.name)
                line.append(", valueSerializer = $valueSer")
                line.append(", valueGetter = { (it as $variantClass).${p.name} }")
                line.append(", valueBuilder = { $variantClass(it as $castType) }")
            }
            if (v.props.isNotEmpty()) {
                val fieldsList = v.props.joinToString(", ") { "\"${it.serialName}\"" }
                line.append(", fields = listOf($fieldsList)")
            }
            line.append(")")
            variantLines.add(line.toString())
        }
        sb.appendLine(variantLines.joinToString(",\n"))
        sb.appendLine("        )")
        sb.appendLine("    )")
        sb.appendLine()
        sb.appendLine("    override val descriptor = union.descriptor")
        sb.appendLine("    override fun serialize(encoder: Encoder, value: $clsName) = union.serialize(encoder, value)")
        sb.appendLine("    override fun deserialize(decoder: Decoder): $clsName = union.deserialize(decoder)")
        sb.appendLine("}")

        val content = sb.toString()
        return Pair(fileName, content)
    }

    // produce serializer expression string for embedding in generated code
    private fun serializerExpr(typeStr: String?, modelsPkg: String, clsName: String, ownerVariant: String?): String {
        val raw = sanitizeType(typeStr)
        val isNullable = (typeStr ?: "").trim().endsWith("?")
        val listRegex = Regex("^(?:[\\w\\.]+\\.)?(?:List|MutableList|ArrayList)\\s*<\\s*(.+)\\s*>")
        val mapRegex = Regex("^(?:[\\w\\.]+\\.)?(?:Map|MutableMap)\\s*<\\s*([^,]+)\\s*,\\s*(.+)\\s*>")
        listRegex.matchEntire(raw)?.let { m ->
            val inner = m.groups[1]!!.value
            val innerExpr = serializerExpr(inner, modelsPkg, clsName, ownerVariant)
            return if (isNullable) "serializer<kotlin.collections.List<${fqType(inner, modelsPkg, clsName, ownerVariant)}>?>()" else "ListSerializer($innerExpr)"
        }
        mapRegex.matchEntire(raw)?.let { m ->
            val k = m.groups[1]!!.value
            val v = m.groups[2]!!.value
            val ks = serializerExpr(k, modelsPkg, clsName, ownerVariant)
            val vs = serializerExpr(v, modelsPkg, clsName, ownerVariant)
            return if (isNullable) "serializer<kotlin.collections.Map<${fqType(k, modelsPkg, clsName, ownerVariant)}, ${fqType(v, modelsPkg, clsName, ownerVariant)}>?>()" else "MapSerializer($ks, $vs)"
        }
        val primitives = mapOf(
            "String" to "kotlin.String",
            "Int" to "kotlin.Int",
            "Long" to "kotlin.Long",
            "Double" to "kotlin.Double",
            "Float" to "kotlin.Float",
            "Boolean" to "kotlin.Boolean",
            "Byte" to "kotlin.Byte",
            "Short" to "kotlin.Short",
            "Char" to "kotlin.Char",
            "Any" to "kotlin.Any"
        )
        if (primitives.containsKey(raw)) {
            val t = primitives[raw]!!
            return "serializer<${t}${if (isNullable) "?" else ""}>()"
        }
        if (raw.contains('.')) {
            return "serializer<${raw}${if (isNullable) "?" else ""}>()"
        }
        if (!ownerVariant.isNullOrBlank()) {
            val nested = "${modelsPkg}.${clsName}.${ownerVariant}.${raw}"
            return "serializer<${nested}${if (isNullable) "?" else ""}>()"
        }
        val cn = "${modelsPkg}.${raw}"
        return "serializer<${cn}${if (isNullable) "?" else ""}>()"
    }

    private fun fqType(typeStr: String?, modelsPkg: String, clsName: String, ownerVariant: String?): String {
        val raw = sanitizeType(typeStr)
        val listRegex = Regex("^(?:[\\w\\.]+\\.)?(?:List|MutableList|ArrayList)\\s*<\\s*(.+)\\s*>")
        val mapRegex = Regex("^(?:[\\w\\.]+\\.)?(?:Map|MutableMap)\\s*<\\s*([^,]+)\\s*,\\s*(.+)\\s*>")
        listRegex.matchEntire(raw)?.let { m ->
            val inner = fqType(m.groups[1]!!.value, modelsPkg, clsName, ownerVariant)
            return "kotlin.collections.List<$inner>"
        }
        mapRegex.matchEntire(raw)?.let { m ->
            val k = fqType(m.groups[1]!!.value, modelsPkg, clsName, ownerVariant)
            val v = fqType(m.groups[2]!!.value, modelsPkg, clsName, ownerVariant)
            return "kotlin.collections.Map<$k, $v>"
        }
        val primitives = setOf("String","Int","Long","Double","Float","Boolean","Byte","Short","Char","Any")
        if (primitives.contains(raw)) return "kotlin.$raw"
        if (raw.contains('.')) return raw
        if (!ownerVariant.isNullOrBlank()) {
            return "${modelsPkg}.${clsName}.${ownerVariant}.${raw}"
        }
        return "${modelsPkg}.${raw}"
    }

    private fun fqTypeWithNullability(typeStr: String?, modelsPkg: String, clsName: String, ownerVariant: String?): String {
        val isNullable = (typeStr ?: "").trim().endsWith("?")
        val base = fqType(typeStr, modelsPkg, clsName, ownerVariant)
        return if (isNullable) "$base?" else base
    }

    private fun sanitizeType(raw: String?): String {
        if (raw == null) return ""
        var s = raw.trim()
        val eqIndex = s.indexOf('=')
        if (eqIndex >= 0) s = s.take(eqIndex).trimEnd()
        s = s.trimEnd { it == ',' || it == ')' || it == ']' }
        while (s.endsWith("?")) s = s.dropLast(1).trimEnd()
        if (s.startsWith("`") && s.endsWith("`") && s.length > 1) s = s.substring(1, s.length - 1)
        return s.trim()
    }

}
