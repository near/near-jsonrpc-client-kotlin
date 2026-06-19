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
import io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest

object RpcCongestionLevelRequestSerializer : KSerializer<RpcCongestionLevelRequest> {
    private val union: BlindUnionSerializer<RpcCongestionLevelRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest",
        variants = listOf(
            Variant(serialName = "block_shard_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest.BlockShardId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest.BlockShardId>() as KSerializer<Any?>, fields = listOf("block_id", "shard_id")),
            Variant(serialName = "chunk_hash", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest.ChunkHash }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest.ChunkHash>() as KSerializer<Any?>, fields = listOf("chunk_id"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcCongestionLevelRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcCongestionLevelRequest = union.deserialize(decoder)
}
