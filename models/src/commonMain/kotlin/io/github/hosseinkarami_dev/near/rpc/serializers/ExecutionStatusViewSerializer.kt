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
import io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView

object ExecutionStatusViewSerializer : KSerializer<ExecutionStatusView> {
    private val union: BlindUnionSerializer<ExecutionStatusView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView",
        variants = listOf(
            Variant(serialName = "Unknown", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Unknown),
            Variant(serialName = "Failure", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure).failure }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.Failure(it as io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError) }, fields = listOf("Failure")),
            Variant(serialName = "SuccessValue", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue>() as KSerializer<Any?>, valueSerializer = serializer<kotlin.String>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue).successValue }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessValue(it as kotlin.String) }, fields = listOf("SuccessValue")),
            Variant(serialName = "SuccessReceiptId", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId).successReceiptId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExecutionStatusView.SuccessReceiptId(it as io.github.hosseinkarami_dev.near.rpc.models.CryptoHash) }, fields = listOf("SuccessReceiptId"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: ExecutionStatusView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): ExecutionStatusView = union.deserialize(decoder)
}
