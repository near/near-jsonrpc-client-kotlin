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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest

object RpcViewAccessKeyRequestSerializer : KSerializer<RpcViewAccessKeyRequest> {
    private val union: BlindUnionSerializer<RpcViewAccessKeyRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest",
        variants = listOf(
            Variant(serialName = "block_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest.BlockId>() as KSerializer<Any?>, fields = listOf("block_id", "account_id", "public_key")),
            Variant(serialName = "finality", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest.Finality }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest.Finality>() as KSerializer<Any?>, fields = listOf("finality", "account_id", "public_key")),
            Variant(serialName = "sync_checkpoint", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest.SyncCheckpoint }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest.SyncCheckpoint>() as KSerializer<Any?>, fields = listOf("sync_checkpoint", "account_id", "public_key"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcViewAccessKeyRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcViewAccessKeyRequest = union.deserialize(decoder)
}
