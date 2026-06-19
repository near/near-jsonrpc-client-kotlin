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
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest

object RpcChunkRequestSerializer : KSerializer<RpcChunkRequest> {
    private val union: BlindUnionSerializer<RpcChunkRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest",
        variants = listOf(
            Variant(serialName = "block_shard_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest.BlockShardId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest.BlockShardId>() as KSerializer<Any?>, fields = listOf("block_id", "shard_id")),
            Variant(serialName = "chunk_hash", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest.ChunkHash }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest.ChunkHash>() as KSerializer<Any?>, fields = listOf("chunk_id"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcChunkRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcChunkRequest = union.deserialize(decoder)
}
