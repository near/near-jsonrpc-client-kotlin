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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest

object RpcViewAccountRequestSerializer : KSerializer<RpcViewAccountRequest> {
    private val union: BlindUnionSerializer<RpcViewAccountRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest",
        variants = listOf(
            Variant(serialName = "block_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest.BlockId>() as KSerializer<Any?>, fields = listOf("block_id", "account_id")),
            Variant(serialName = "finality", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest.Finality }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest.Finality>() as KSerializer<Any?>, fields = listOf("finality", "account_id")),
            Variant(serialName = "sync_checkpoint", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest.SyncCheckpoint }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest.SyncCheckpoint>() as KSerializer<Any?>, fields = listOf("sync_checkpoint", "account_id"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcViewAccountRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcViewAccountRequest = union.deserialize(decoder)
}
