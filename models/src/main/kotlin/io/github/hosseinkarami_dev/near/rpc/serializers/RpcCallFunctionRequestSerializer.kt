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
import io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest

object RpcCallFunctionRequestSerializer : KSerializer<RpcCallFunctionRequest> {
    private val union: BlindUnionSerializer<RpcCallFunctionRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest",
        variants = listOf(
            Variant(serialName = "block_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>() as KSerializer<Any?>, fields = listOf("block_id", "account_id", "args_base64", "method_name")),
            Variant(serialName = "finality", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>() as KSerializer<Any?>, fields = listOf("finality", "account_id", "args_base64", "method_name")),
            Variant(serialName = "sync_checkpoint", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>() as KSerializer<Any?>, fields = listOf("sync_checkpoint", "account_id", "args_base64", "method_name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcCallFunctionRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcCallFunctionRequest = union.deserialize(decoder)
}
