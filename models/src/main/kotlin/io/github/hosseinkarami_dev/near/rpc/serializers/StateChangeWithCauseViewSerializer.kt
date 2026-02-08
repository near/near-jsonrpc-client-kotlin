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
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView

object StateChangeWithCauseViewSerializer : KSerializer<StateChangeWithCauseView> {
    private val union: BlindUnionSerializer<StateChangeWithCauseView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView",
        variants = listOf(
            Variant(serialName = "account_update", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountUpdate>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "account_deletion", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccountDeletion>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "access_key_update", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyUpdate>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "access_key_deletion", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.AccessKeyDeletion>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "gas_key_nonce_update", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.GasKeyNonceUpdate>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "data_update", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataUpdate>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "data_deletion", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.DataDeletion>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "contract_code_update", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeUpdate>() as KSerializer<Any?>, fields = listOf("change", "type", "cause")),
            Variant(serialName = "contract_code_deletion", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeWithCauseView.ContractCodeDeletion>() as KSerializer<Any?>, fields = listOf("change", "type", "cause"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: StateChangeWithCauseView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): StateChangeWithCauseView = union.deserialize(decoder)
}
