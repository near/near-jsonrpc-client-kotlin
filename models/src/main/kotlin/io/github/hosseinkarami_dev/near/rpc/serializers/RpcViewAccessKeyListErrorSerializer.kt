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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError

object RpcViewAccessKeyListErrorSerializer : KSerializer<RpcViewAccessKeyListError> {
    private val union: BlindUnionSerializer<RpcViewAccessKeyListError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INVALID_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.InvalidAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.InvalidAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.UnknownAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.UnknownAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcViewAccessKeyListError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcViewAccessKeyListError = union.deserialize(decoder)
}
