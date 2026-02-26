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
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest

object RpcStateChangesInBlockRequestSerializer : KSerializer<RpcStateChangesInBlockRequest> {
    private val union: BlindUnionSerializer<RpcStateChangesInBlockRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest",
        variants = listOf(
            Variant(serialName = "block_id", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId).blockId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.BlockId(it as io.github.hosseinkarami_dev.near.rpc.models.BlockId) }, fields = listOf("block_id")),
            Variant(serialName = "finality", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality).finality }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.Finality(it as io.github.hosseinkarami_dev.near.rpc.models.Finality) }, fields = listOf("finality")),
            Variant(serialName = "sync_checkpoint", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint).syncCheckpoint }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest.SyncCheckpoint(it as io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint) }, fields = listOf("sync_checkpoint"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcStateChangesInBlockRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcStateChangesInBlockRequest = union.deserialize(decoder)
}
