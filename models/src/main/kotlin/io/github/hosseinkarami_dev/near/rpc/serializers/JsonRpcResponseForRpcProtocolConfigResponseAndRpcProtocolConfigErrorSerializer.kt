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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError

object JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigErrorSerializer : KSerializer<JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError = union.deserialize(decoder)
}
