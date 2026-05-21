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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest

object RpcViewStateRequestSerializer : KSerializer<RpcViewStateRequest> {
    private val union: BlindUnionSerializer<RpcViewStateRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest",
        variants = listOf(
            Variant(serialName = "block_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest.BlockId>() as KSerializer<Any?>, fields = listOf("block_id", "account_id", "after_key_base64", "include_proof", "limit", "prefix_base64")),
            Variant(serialName = "finality", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest.Finality }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest.Finality>() as KSerializer<Any?>, fields = listOf("finality", "account_id", "after_key_base64", "include_proof", "limit", "prefix_base64")),
            Variant(serialName = "sync_checkpoint", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest.SyncCheckpoint }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest.SyncCheckpoint>() as KSerializer<Any?>, fields = listOf("sync_checkpoint", "account_id", "after_key_base64", "include_proof", "limit", "prefix_base64"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcViewStateRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcViewStateRequest = union.deserialize(decoder)
}
