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
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptError

object RpcReceiptErrorSerializer : KSerializer<RpcReceiptError> {
    private val union: BlindUnionSerializer<RpcReceiptError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptError",
        variants = listOf(
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_RECEIPT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptError.UnknownReceipt }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptError.UnknownReceipt>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcReceiptError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcReceiptError = union.deserialize(decoder)
}
