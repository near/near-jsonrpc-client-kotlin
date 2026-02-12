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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError

object JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyErrorSerializer : KSerializer<JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError = union.deserialize(decoder)
}
