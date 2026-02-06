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
import io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView

object StateChangeKindViewSerializer : KSerializer<StateChangeKindView> {
    private val union: BlindUnionSerializer<StateChangeKindView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView",
        variants = listOf(
            Variant(serialName = "account_touched", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccountTouched>() as KSerializer<Any?>, fields = listOf("account_id", "type")),
            Variant(serialName = "access_key_touched", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.AccessKeyTouched>() as KSerializer<Any?>, fields = listOf("account_id", "type")),
            Variant(serialName = "data_touched", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.DataTouched>() as KSerializer<Any?>, fields = listOf("account_id", "type")),
            Variant(serialName = "contract_code_touched", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateChangeKindView.ContractCodeTouched>() as KSerializer<Any?>, fields = listOf("account_id", "type"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: StateChangeKindView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): StateChangeKindView = union.deserialize(decoder)
}
