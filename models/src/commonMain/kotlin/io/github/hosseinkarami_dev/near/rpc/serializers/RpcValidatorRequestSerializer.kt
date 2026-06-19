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
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest

object RpcValidatorRequestSerializer : KSerializer<RpcValidatorRequest> {
    private val union: BlindUnionSerializer<RpcValidatorRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest",
        variants = listOf(
            Variant(serialName = "epoch_id", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.EpochId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId).epochId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.EpochId(it as io.github.hosseinkarami_dev.near.rpc.models.EpochId) }, fields = listOf("epoch_id")),
            Variant(serialName = "block_id", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId).blockId }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.BlockId(it as io.github.hosseinkarami_dev.near.rpc.models.BlockId) }, fields = listOf("block_id")),
            Variant(serialName = "latest", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest>() as KSerializer<Any?>, valueSerializer = serializer<kotlinx.serialization.json.JsonElement?>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest).latest }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest.Latest(it as kotlinx.serialization.json.JsonElement?) }, fields = listOf("latest"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcValidatorRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcValidatorRequest = union.deserialize(decoder)
}
