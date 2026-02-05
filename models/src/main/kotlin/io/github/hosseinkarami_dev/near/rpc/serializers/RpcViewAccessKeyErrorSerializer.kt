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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError

object RpcViewAccessKeyErrorSerializer : KSerializer<RpcViewAccessKeyError> {
    private val union: BlindUnionSerializer<RpcViewAccessKeyError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INVALID_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_ACCESS_KEY", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcViewAccessKeyError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcViewAccessKeyError = union.deserialize(decoder)
}
