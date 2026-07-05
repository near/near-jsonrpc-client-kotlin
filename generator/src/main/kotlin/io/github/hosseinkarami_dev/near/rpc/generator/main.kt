package io.github.hosseinkarami_dev.near.rpc.generator

import io.github.hosseinkarami_dev.near.rpc.generator.generators.ClientGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.ClientTestGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.MockGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.ModelGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.ModelTestGenerator
import io.github.hosseinkarami_dev.near.rpc.generator.generators.SerializerGenerator
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import java.io.File

fun main(args: Array<String>) {
    val parser = ArgParser("generator")

    val rootDir = System.getenv("GITHUB_WORKSPACE") ?: File(
        System.getProperty("user.dir"),
        ".."
    ).canonicalPath

    val openApiUrl by parser.option(
        ArgType.String,
        fullName = "openapi-url",
        description = "URL to the OpenAPI specification"
    )
        //.default("https://raw.githubusercontent.com/near/nearcore/refs/heads/2.9.0/chain/jsonrpc/openapi/openapi.json")
        .default("https://raw.githubusercontent.com/near/nearcore/refs/heads/master/chain/jsonrpc/openapi/openapi.json")

    val modelsOut by parser.option(
        ArgType.String,
        fullName = "models-out",
        description = "Output directory for generated models"
    ).default("$rootDir/models/src/commonMain/kotlin/")

    val clientOut by parser.option(
        ArgType.String,
        fullName = "client-out",
        description = "Output directory for generated client"
    ).default("$rootDir/client/src/commonMain/kotlin/")

    val testsOut = "$rootDir/client/src/jvmTest/kotlin/"

    parser.parse(args)

    val spec = fetchOpenApiSpec(openApiUrl)

    val modelPackage = "io.github.hosseinkarami_dev.near.rpc.models"
    val clientPackage = "io.github.hosseinkarami_dev.near.rpc.client"
    val testsPackage = "io.github.hosseinkarami_dev.near.rpc.client"
    val modelsTestsPackage = "io.github.hosseinkarami_dev.near.rpc.models"
    val serializerPackage = modelPackage.replace(".models", ".serializers")
    val mocksForClient = File("$rootDir/client/src/jvmTest/resources/mock")
    val mocksForModels = File("$rootDir/models/src/commonTest/resources/mock")

    val serializerFiles = File(modelsOut + serializerPackage.replace(".", "/"))
    val modelFiles = File(modelsOut + modelPackage.replace(".", "/"))
    val nearClientFile = File(clientOut + clientPackage.replace(".", "/"))

    val testsDirectory = File(testsOut + clientPackage.replace(".", "/"))
    val modelsTestsDirectory = File("$rootDir/models/src/jvmTest/kotlin/" + modelPackage.replace(".", "/"))

    serializerFiles.mkdirs()
    modelFiles.mkdirs()
    nearClientFile.mkdirs()
    mocksForClient.mkdirs()
    modelsTestsDirectory.mkdirs()
    mocksForModels.mkdirs()

    serializerFiles.takeIf { it.exists() }?.listFiles()?.forEach { it.delete() }
    modelFiles.takeIf { it.exists() }?.listFiles()?.forEach { it.delete() }
    mocksForClient.takeIf { it.exists() }?.listFiles()?.filter { it.extension == "json" }?.forEach { it.delete() }
    mocksForModels.takeIf { it.exists() }?.listFiles()?.filter { it.extension == "json" }?.forEach { it.delete() }

    nearClientFile.delete()

    // write shared serializers used by generated code
    writeBlindUnionSerializer(serializerFiles, serializerPackage)

    //models & serializers
    ModelGenerator.generateAll(
        spec = spec,
        output = File(modelsOut),
        serializerPackage = serializerPackage,
        packageName = modelPackage
    ) { sealedClasses ->

        SerializerGenerator.generateFromSealedInfos(
            sealedInfos = sealedClasses,
            serializerPackage = serializerPackage,
            output = File(modelsOut)
        )
    }

    ClientGenerator.generateNearClientFile(
        spec = spec,
        output = File(clientOut),
        clientPackage = clientPackage,
        modelsPackage = modelPackage
    )

    //tests
    ModelTestGenerator.generateTestsForModels(
        spec = spec,
        output = testsDirectory,
        testsPackage = testsPackage,
        modelsPackage = modelPackage
    )

    ModelTestGenerator.generateTestsForModels(
        spec = spec,
        output = modelsTestsDirectory,
        testsPackage = modelsTestsPackage,
        modelsPackage = modelPackage,
        resourceDir = "src/commonTest/resources/mock",
        fileName = "ModelSerializationRuntimeTest.kt",
        testClassName = "ModelSerializationRuntimeTest"
    )

    ClientTestGenerator.generateTestsForClient(
        spec = spec,
        output = testsDirectory,
        testsPackage = testsPackage,
        clientPackage = clientPackage,
        modelsPackage = modelPackage
    )

    MockGenerator.generate(spec, listOf(mocksForClient, mocksForModels))
}

private fun writeBlindUnionSerializer(outputDir: File, serializerPackage: String) {
    val file = File(outputDir, "BlindUnionSerializer.kt")
    val content = """
        package $serializerPackage

        import kotlinx.serialization.KSerializer
        import kotlinx.serialization.SerializationException
        import kotlinx.serialization.descriptors.SerialDescriptor
        import kotlinx.serialization.descriptors.buildClassSerialDescriptor
        import kotlinx.serialization.encoding.Decoder
        import kotlinx.serialization.encoding.Encoder
        import kotlinx.serialization.json.Json
        import kotlinx.serialization.json.JsonDecoder
        import kotlinx.serialization.json.JsonElement
        import kotlinx.serialization.json.JsonEncoder
        import kotlinx.serialization.json.JsonObject
        import kotlinx.serialization.json.JsonPrimitive
        import kotlinx.serialization.serializer

        class BlindUnionSerializer<T>(
            private val serialName: String,
            private val variants: List<Variant<T>>
        ) : KSerializer<T> {
            override val descriptor: SerialDescriptor =
                buildClassSerialDescriptor(serialName) {
                    variants.forEach { element(it.serialName, serializer<JsonElement>().descriptor) }
                }

            override fun serialize(encoder: Encoder, value: T) {
                val variant = variants.firstOrNull { it.isInstance(value) }
                    ?: throw SerializationException("Unknown variant for ${'$'}serialName: ${'$'}value")
                if (encoder is JsonEncoder) {
                    val elem = variant.encodeToJson(encoder.json, value)
                    encoder.encodeJsonElement(elem)
                    return
                }
                @Suppress("UNCHECKED_CAST")
                encoder.encodeSerializableValue(variant.fullSerializer as KSerializer<Any?>, value as Any?)
            }

            override fun deserialize(decoder: Decoder): T {
                if (decoder !is JsonDecoder) {
                    throw SerializationException("Cannot deserialize ${'$'}serialName with non-JSON decoder")
                }
                val json = decoder.json
                val element = decoder.decodeJsonElement()
                val matches = mutableListOf<T>()

                fun tryAdd(block: () -> T) {
                    try {
                        matches.add(block())
                    } catch (_: Exception) {
                        // ignore
                    }
                }

                if (element is JsonPrimitive && element.isString) {
                    val s = element.content
                    variants.filter { it.kind == VariantKind.OBJECT && it.serialName == s }
                        .forEach { matches.add(it.objectInstance as T) }
                }

                if (element is JsonObject) {
                    if (element.size == 1) {
                        val entry = element.entries.first()
                        variants.filter { it.kind == VariantKind.WRAPPED && it.serialName == entry.key }
                            .forEach { v ->
                                tryAdd {
                                    val payload = json.decodeFromJsonElement(v.valueSerializer as KSerializer<Any?>, entry.value)
                                    v.valueBuilder!!.invoke(payload)
                                }
                            }
                    }

                    // field-based disambiguation for object-shaped variants
                    val scored = variants.mapNotNull { v ->
                        val fields = v.fields
                        if (fields.isNullOrEmpty()) null else {
                            val matchCount = fields.count { element.containsKey(it) }
                            Pair(v, matchCount)
                        }
                    }
                    val maxScore = scored.maxOfOrNull { it.second } ?: 0
                    if (maxScore > 0) {
                        val best = scored.filter { it.second == maxScore }
                        if (best.size == 1) {
                            val v = best[0].first
                            val decoded = tryDecodeVariant(v, element, json)
                            if (decoded != null) return decoded
                        }
                    }
                }

                if (matches.size == 1) return matches.first()
                if (matches.size > 1) {
                    throw SerializationException("Ambiguous ${'$'}serialName: multiple variants matched")
                }

                variants.forEach { v ->
                    when (v.kind) {
                        VariantKind.OBJECT -> {
                            if (element is JsonPrimitive && element.isString && element.content == v.serialName) {
                                matches.add(v.objectInstance as T)
                            }
                        }
                        VariantKind.VALUE -> {
                            tryAdd {
                                val payload = json.decodeFromJsonElement(v.valueSerializer as KSerializer<Any?>, element)
                                v.valueBuilder!!.invoke(payload)
                            }
                        }
                        VariantKind.WRAPPED -> {
                            if (element is JsonObject) {
                                val payloadElem = element[v.serialName]
                                if (payloadElem != null) {
                                    tryAdd {
                                        val payload = json.decodeFromJsonElement(v.valueSerializer as KSerializer<Any?>, payloadElem)
                                        v.valueBuilder!!.invoke(payload)
                                    }
                                }
                            }
                        }
                        VariantKind.DEFAULT -> {
                            tryAdd { json.decodeFromJsonElement(v.fullSerializer, element) as T }
                        }
                    }
                }

                if (matches.size == 1) return matches.first()
                if (matches.isEmpty()) {
                    throw SerializationException("Missing discriminator or recognizable variant in ${'$'}serialName")
                }
                throw SerializationException("Ambiguous ${'$'}serialName: multiple variants matched")
            }
        }

        data class Variant<T>(
            val serialName: String,
            val kind: VariantKind,
            val isInstance: (T) -> Boolean,
            val fullSerializer: KSerializer<Any?>,
            val valueSerializer: KSerializer<Any?>? = null,
            val valueGetter: ((T) -> Any?)? = null,
            val valueBuilder: ((Any?) -> T)? = null,
            val objectInstance: T? = null,
            val fields: List<String>? = null
        ) {
            fun encodeToJson(json: Json, value: T): JsonElement {
                return when (kind) {
                    VariantKind.OBJECT -> JsonPrimitive(serialName)
                    VariantKind.VALUE -> json.encodeToJsonElement(valueSerializer as KSerializer<Any?>, valueGetter!!.invoke(value))
                    VariantKind.WRAPPED -> JsonObject(
                        mapOf(
                            serialName to json.encodeToJsonElement(valueSerializer as KSerializer<Any?>, valueGetter!!.invoke(value))
                        )
                    )
                    VariantKind.DEFAULT -> json.encodeToJsonElement(fullSerializer, value as Any?)
                }
            }
        }

        enum class VariantKind {
            OBJECT,
            VALUE,
            WRAPPED,
            DEFAULT
        }

        private fun <T> tryDecodeVariant(
            v: Variant<T>,
            element: JsonElement,
            json: Json
        ): T? {
            return try {
                when (v.kind) {
                    VariantKind.OBJECT -> null
                    VariantKind.VALUE -> {
                        val payload = json.decodeFromJsonElement(v.valueSerializer as KSerializer<Any?>, element)
                        v.valueBuilder!!.invoke(payload)
                    }
                    VariantKind.WRAPPED -> {
                        val obj = element as? JsonObject ?: return null
                        val payloadElem = obj[v.serialName] ?: return null
                        val payload = json.decodeFromJsonElement(v.valueSerializer as KSerializer<Any?>, payloadElem)
                        v.valueBuilder!!.invoke(payload)
                    }
                    VariantKind.DEFAULT -> json.decodeFromJsonElement(v.fullSerializer, element) as T
                }
            } catch (_: Exception) {
                null
            }
        }
    """.trimIndent()
    file.writeText(content)
}
