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
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError

object RpcLightClientProofErrorSerializer : KSerializer<RpcLightClientProofError> {
    private val union: BlindUnionSerializer<RpcLightClientProofError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INCONSISTENT_STATE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.InconsistentState }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.InconsistentState>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "NOT_CONFIRMED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.NotConfirmed }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.NotConfirmed>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_TRANSACTION_OR_RECEIPT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.UnknownTransactionOrReceipt }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.UnknownTransactionOrReceipt>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNAVAILABLE_SHARD", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.UnavailableShard }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.UnavailableShard>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "CHUNK_NOT_CERTIFIED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.ChunkNotCertified }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.ChunkNotCertified>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "LIGHT_CLIENT_HEAD_TOO_OLD", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.LightClientHeadTooOld }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.LightClientHeadTooOld>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientProofError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcLightClientProofError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcLightClientProofError = union.deserialize(decoder)
}
