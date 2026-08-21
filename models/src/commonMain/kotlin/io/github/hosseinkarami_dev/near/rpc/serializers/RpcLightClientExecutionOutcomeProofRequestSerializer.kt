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
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionOutcomeProofRequest

object RpcLightClientExecutionOutcomeProofRequestSerializer : KSerializer<RpcLightClientExecutionOutcomeProofRequest> {
    private val union: BlindUnionSerializer<RpcLightClientExecutionOutcomeProofRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionOutcomeProofRequest",
        variants = listOf(
            Variant(serialName = "transaction", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionOutcomeProofRequest.Transaction }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionOutcomeProofRequest.Transaction>() as KSerializer<Any?>, fields = listOf("sender_id", "transaction_hash", "type", "light_client_head")),
            Variant(serialName = "receipt", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionOutcomeProofRequest.Receipt }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionOutcomeProofRequest.Receipt>() as KSerializer<Any?>, fields = listOf("receipt_id", "receiver_id", "type", "light_client_head"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcLightClientExecutionOutcomeProofRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcLightClientExecutionOutcomeProofRequest = union.deserialize(decoder)
}
