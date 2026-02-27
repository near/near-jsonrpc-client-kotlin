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
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse

object RpcTransactionResponseSerializer : KSerializer<RpcTransactionResponse> {
    private val union: BlindUnionSerializer<RpcTransactionResponse> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse",
        variants = listOf(
            Variant(serialName = "FinalExecutionOutcomeWithReceiptView", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeWithReceiptView>() as KSerializer<Any?>, fields = listOf("receipts", "receipts_outcome", "status", "transaction", "transaction_outcome", "final_execution_status")),
            Variant(serialName = "FinalExecutionOutcomeView", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionOutcomeView>() as KSerializer<Any?>, fields = listOf("receipts_outcome", "status", "transaction", "transaction_outcome", "final_execution_status")),
            Variant(serialName = "final_execution_status", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionStatus }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionStatus>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionStatus).finalExecutionStatus }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse.FinalExecutionStatus(it as io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus) }, fields = listOf("final_execution_status"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcTransactionResponse) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcTransactionResponse = union.deserialize(decoder)
}
