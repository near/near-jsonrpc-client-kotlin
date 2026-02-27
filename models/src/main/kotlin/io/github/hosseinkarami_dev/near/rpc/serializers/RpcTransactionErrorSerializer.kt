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
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError

object RpcTransactionErrorSerializer : KSerializer<RpcTransactionError> {
    private val union: BlindUnionSerializer<RpcTransactionError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError",
        variants = listOf(
            Variant(serialName = "INVALID_TRANSACTION", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InvalidTransaction>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "DOES_NOT_TRACK_SHARD", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.DoesNotTrackShard>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "REQUEST_ROUTED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.RequestRouted>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_TRANSACTION", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.UnknownTransaction>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "TIMEOUT_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionError.TimeoutError>() as KSerializer<Any?>, fields = listOf("name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcTransactionError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcTransactionError = union.deserialize(decoder)
}
