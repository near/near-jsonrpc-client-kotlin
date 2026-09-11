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
import io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError

object RpcIndexerBlockErrorSerializer : KSerializer<RpcIndexerBlockError> {
    private val union: BlindUnionSerializer<RpcIndexerBlockError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError",
        variants = listOf(
            Variant(serialName = "DATA_UNAVAILABLE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.DataUnavailable }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.DataUnavailable>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INCOMPLETE_DATA", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.IncompleteData }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.IncompleteData>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNSUPPORTED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.Unsupported }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.Unsupported>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "LIMIT_EXCEEDED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.LimitExceeded }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.LimitExceeded>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "BUSY", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.Busy }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.Busy>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcIndexerBlockError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcIndexerBlockError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcIndexerBlockError = union.deserialize(decoder)
}
