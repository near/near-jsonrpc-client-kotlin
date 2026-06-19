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
import io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError

object RpcStatusErrorSerializer : KSerializer<RpcStatusError> {
    private val union: BlindUnionSerializer<RpcStatusError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError",
        variants = listOf(
            Variant(serialName = "NODE_IS_SYNCING", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NodeIsSyncing>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "NO_NEW_BLOCKS", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.NoNewBlocks>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "EPOCH_OUT_OF_BOUNDS", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.EpochOutOfBounds>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStatusError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcStatusError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcStatusError = union.deserialize(decoder)
}
