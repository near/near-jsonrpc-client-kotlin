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
import io.github.hosseinkarami_dev.near.rpc.models.AccountContractView

object AccountContractViewSerializer : KSerializer<AccountContractView> {
    private val union: BlindUnionSerializer<AccountContractView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.AccountContractView",
        variants = listOf(
            Variant(serialName = "local", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.Local }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.Local>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.Local).local }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.Local(it as io.github.hosseinkarami_dev.near.rpc.models.CryptoHash) }, fields = listOf("local")),
            Variant(serialName = "global_hash", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalHash }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalHash>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalHash).globalHash }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalHash(it as io.github.hosseinkarami_dev.near.rpc.models.CryptoHash) }, fields = listOf("global_hash")),
            Variant(serialName = "global_account_id", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalAccountId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalAccountId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalAccountId).globalAccountId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccountContractView.GlobalAccountId(it as io.github.hosseinkarami_dev.near.rpc.models.AccountId) }, fields = listOf("global_account_id"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: AccountContractView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): AccountContractView = union.deserialize(decoder)
}
