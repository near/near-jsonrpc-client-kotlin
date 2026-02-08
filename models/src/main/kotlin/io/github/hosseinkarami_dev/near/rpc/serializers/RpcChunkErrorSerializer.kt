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
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError

object RpcChunkErrorSerializer : KSerializer<RpcChunkError> {
    private val union: BlindUnionSerializer<RpcChunkError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError",
        variants = listOf(
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INVALID_SHARD_ID", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.InvalidShardId>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_CHUNK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcChunkError.UnknownChunk>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcChunkError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcChunkError = union.deserialize(decoder)
}
