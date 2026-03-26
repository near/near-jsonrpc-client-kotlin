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
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError

object RpcReceiptToTxErrorSerializer : KSerializer<RpcReceiptToTxError> {
    private val union: BlindUnionSerializer<RpcReceiptToTxError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_RECEIPT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.UnknownReceipt }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.UnknownReceipt>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "DEPTH_EXCEEDED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.DepthExceeded }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.DepthExceeded>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNSUPPORTED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.Unsupported }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.Unsupported>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcReceiptToTxError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcReceiptToTxError = union.deserialize(decoder)
}
