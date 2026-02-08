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
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView

object GlobalContractIdentifierViewSerializer : KSerializer<GlobalContractIdentifierView> {
    private val union: BlindUnionSerializer<GlobalContractIdentifierView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView",
        variants = listOf(
            Variant(serialName = "hash", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash).hash }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash(it as io.github.hosseinkarami_dev.near.rpc.models.CryptoHash) }, fields = listOf("hash")),
            Variant(serialName = "account_id", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId).accountId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId(it as io.github.hosseinkarami_dev.near.rpc.models.AccountId) }, fields = listOf("account_id"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: GlobalContractIdentifierView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): GlobalContractIdentifierView = union.deserialize(decoder)
}
