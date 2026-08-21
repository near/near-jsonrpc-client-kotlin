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
import io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget

object StateProofTargetSerializer : KSerializer<StateProofTarget> {
    private val union: BlindUnionSerializer<StateProofTarget> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget",
        variants = listOf(
            Variant(serialName = "account", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.Account }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.Account>() as KSerializer<Any?>, fields = listOf("account_id", "target_type")),
            Variant(serialName = "local_contract_code", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.LocalContractCode }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.LocalContractCode>() as KSerializer<Any?>, fields = listOf("account_id", "target_type")),
            Variant(serialName = "contract_data", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.ContractData }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.ContractData>() as KSerializer<Any?>, fields = listOf("account_id", "key", "target_type")),
            Variant(serialName = "access_key", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.AccessKey }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateProofTarget.AccessKey>() as KSerializer<Any?>, fields = listOf("account_id", "public_key", "target_type"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: StateProofTarget) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): StateProofTarget = union.deserialize(decoder)
}
