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
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest

object RpcProtocolConfigRequestSerializer : KSerializer<RpcProtocolConfigRequest> {
    private val union: BlindUnionSerializer<RpcProtocolConfigRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest",
        variants = listOf(
            Variant(serialName = "block_id", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.BlockId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.BlockId).blockId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.BlockId(it as io.github.hosseinkarami_dev.near.rpc.models.BlockId) }, fields = listOf("block_id")),
            Variant(serialName = "finality", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.Finality }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.Finality>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.Finality).finality }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.Finality(it as io.github.hosseinkarami_dev.near.rpc.models.Finality) }, fields = listOf("finality")),
            Variant(serialName = "sync_checkpoint", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.SyncCheckpoint }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.SyncCheckpoint>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.SyncCheckpoint).syncCheckpoint }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest.SyncCheckpoint(it as io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint) }, fields = listOf("sync_checkpoint"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcProtocolConfigRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcProtocolConfigRequest = union.deserialize(decoder)
}
