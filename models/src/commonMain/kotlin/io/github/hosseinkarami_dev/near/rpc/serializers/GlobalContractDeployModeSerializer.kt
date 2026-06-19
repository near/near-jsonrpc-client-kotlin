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
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode

object GlobalContractDeployModeSerializer : KSerializer<GlobalContractDeployMode> {
    private val union: BlindUnionSerializer<GlobalContractDeployMode> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode",
        variants = listOf(
            Variant(serialName = "CodeHash", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.CodeHash),
            Variant(serialName = "AccountId", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.GlobalContractDeployMode.AccountId)
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: GlobalContractDeployMode) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): GlobalContractDeployMode = union.deserialize(decoder)
}
