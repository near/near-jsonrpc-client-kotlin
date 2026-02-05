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
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest

object RpcLightClientExecutionProofRequestSerializer : KSerializer<RpcLightClientExecutionProofRequest> {
    private val union: BlindUnionSerializer<RpcLightClientExecutionProofRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest",
        variants = listOf(
            Variant(serialName = "transaction", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Transaction>() as KSerializer<Any?>, fields = listOf("sender_id", "transaction_hash", "type", "light_client_head")),
            Variant(serialName = "receipt", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest.Receipt>() as KSerializer<Any?>, fields = listOf("receipt_id", "receiver_id", "type", "light_client_head"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcLightClientExecutionProofRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcLightClientExecutionProofRequest = union.deserialize(decoder)
}
