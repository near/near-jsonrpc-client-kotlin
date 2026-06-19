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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest

object RpcViewCodeRequestSerializer : KSerializer<RpcViewCodeRequest> {
    private val union: BlindUnionSerializer<RpcViewCodeRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest",
        variants = listOf(
            Variant(serialName = "block_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest.BlockId>() as KSerializer<Any?>, fields = listOf("block_id", "account_id")),
            Variant(serialName = "finality", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest.Finality }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest.Finality>() as KSerializer<Any?>, fields = listOf("finality", "account_id")),
            Variant(serialName = "sync_checkpoint", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest.SyncCheckpoint }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest.SyncCheckpoint>() as KSerializer<Any?>, fields = listOf("sync_checkpoint", "account_id"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcViewCodeRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcViewCodeRequest = union.deserialize(decoder)
}
