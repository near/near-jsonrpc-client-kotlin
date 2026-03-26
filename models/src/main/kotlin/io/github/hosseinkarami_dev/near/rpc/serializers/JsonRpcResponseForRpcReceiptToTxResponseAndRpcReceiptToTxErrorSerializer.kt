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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError

object JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxErrorSerializer : KSerializer<JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError = union.deserialize(decoder)
}
