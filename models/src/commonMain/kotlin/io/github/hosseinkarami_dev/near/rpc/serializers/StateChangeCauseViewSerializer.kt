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
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView

object StateChangeCauseViewSerializer : KSerializer<StateChangeCauseView> {
    private val union: BlindUnionSerializer<StateChangeCauseView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView",
        variants = listOf(
            Variant(serialName = "not_writable_to_disk", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.NotWritableToDisk>() as KSerializer<Any?>, fields = listOf("type")),
            Variant(serialName = "initial_state", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.InitialState>() as KSerializer<Any?>, fields = listOf("type")),
            Variant(serialName = "transaction_processing", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.TransactionProcessing>() as KSerializer<Any?>, fields = listOf("tx_hash", "type")),
            Variant(serialName = "action_receipt_processing_started", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptProcessingStarted>() as KSerializer<Any?>, fields = listOf("receipt_hash", "type")),
            Variant(serialName = "action_receipt_gas_reward", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ActionReceiptGasReward>() as KSerializer<Any?>, fields = listOf("receipt_hash", "type")),
            Variant(serialName = "receipt_processing", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ReceiptProcessing>() as KSerializer<Any?>, fields = listOf("receipt_hash", "type")),
            Variant(serialName = "postponed_receipt", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.PostponedReceipt>() as KSerializer<Any?>, fields = listOf("receipt_hash", "type")),
            Variant(serialName = "updated_delayed_receipts", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.UpdatedDelayedReceipts>() as KSerializer<Any?>, fields = listOf("type")),
            Variant(serialName = "validator_accounts_update", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.ValidatorAccountsUpdate>() as KSerializer<Any?>, fields = listOf("type")),
            Variant(serialName = "migration", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.Migration>() as KSerializer<Any?>, fields = listOf("type")),
            Variant(serialName = "bandwidth_scheduler_state_update", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeCauseView.BandwidthSchedulerStateUpdate>() as KSerializer<Any?>, fields = listOf("type"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: StateChangeCauseView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): StateChangeCauseView = union.deserialize(decoder)
}
