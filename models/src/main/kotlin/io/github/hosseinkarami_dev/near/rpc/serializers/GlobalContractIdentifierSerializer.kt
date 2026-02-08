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
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier

object GlobalContractIdentifierSerializer : KSerializer<GlobalContractIdentifier> {
    private val union: BlindUnionSerializer<GlobalContractIdentifier> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier",
        variants = listOf(
            Variant(serialName = "CodeHash", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.CodeHash }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.CodeHash>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.CodeHash).codeHash }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.CodeHash(it as io.github.hosseinkarami_dev.near.rpc.models.CryptoHash) }, fields = listOf("CodeHash")),
            Variant(serialName = "AccountId", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.AccountId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.AccountId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.AccountId).accountId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifier.AccountId(it as io.github.hosseinkarami_dev.near.rpc.models.AccountId) }, fields = listOf("AccountId"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: GlobalContractIdentifier) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): GlobalContractIdentifier = union.deserialize(decoder)
}
