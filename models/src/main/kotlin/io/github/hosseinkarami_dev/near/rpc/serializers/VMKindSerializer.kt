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
import io.github.hosseinkarami_dev.near.rpc.models.VMKind

object VMKindSerializer : KSerializer<VMKind> {
    private val union: BlindUnionSerializer<VMKind> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.VMKind",
        variants = listOf(
            Variant(serialName = "Wasmer0", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer0),
            Variant(serialName = "Wasmtime", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmtime),
            Variant(serialName = "Wasmer2", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.VMKind.Wasmer2),
            Variant(serialName = "NearVm", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.VMKind.NearVm)
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: VMKind) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): VMKind = union.deserialize(decoder)
}
