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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError

object JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkErrorSerializer : KSerializer<JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError = union.deserialize(decoder)
}
