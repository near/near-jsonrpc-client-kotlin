package io.github.hosseinkarami_dev.near.rpc.serializers

import io.github.hosseinkarami_dev.near.rpc.serializers.BlindUnionSerializer
import io.github.hosseinkarami_dev.near.rpc.serializers.Variant
import io.github.hosseinkarami_dev.near.rpc.serializers.VariantKind
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.serializer
import io.github.hosseinkarami_dev.near.rpc.models.WasmTrap

object WasmTrapSerializer : KSerializer<WasmTrap> {
    private val union: BlindUnionSerializer<WasmTrap> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.WasmTrap",
        variants = listOf(
            Variant(serialName = "Unreachable", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.Unreachable),
            Variant(serialName = "IncorrectCallIndirectSignature", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IncorrectCallIndirectSignature),
            Variant(serialName = "MemoryOutOfBounds", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MemoryOutOfBounds),
            Variant(serialName = "CallIndirectOOB", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.CallIndirectOOB),
            Variant(serialName = "IllegalArithmetic", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IllegalArithmetic),
            Variant(serialName = "MisalignedAtomicAccess", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.MisalignedAtomicAccess),
            Variant(serialName = "IndirectCallToNull", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.IndirectCallToNull),
            Variant(serialName = "StackOverflow", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.StackOverflow),
            Variant(serialName = "GenericTrap", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.WasmTrap.GenericTrap)
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: WasmTrap) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): WasmTrap = union.deserialize(decoder)
}
