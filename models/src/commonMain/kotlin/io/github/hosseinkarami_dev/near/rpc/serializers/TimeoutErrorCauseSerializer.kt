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
import io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause

object TimeoutErrorCauseSerializer : KSerializer<TimeoutErrorCause> {
    private val union: BlindUnionSerializer<TimeoutErrorCause> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause",
        variants = listOf(
            Variant(serialName = "NOT_OBSERVED", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.NotObserved }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.NotObserved>() as KSerializer<Any?>, fields = listOf("cause")),
            Variant(serialName = "PENDING", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.Pending }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.Pending>() as KSerializer<Any?>, fields = listOf("cause", "status")),
            Variant(serialName = "DOES_NOT_TRACK_SHARD", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.DoesNotTrackShard }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.DoesNotTrackShard>() as KSerializer<Any?>, fields = listOf("cause", "shard_id")),
            Variant(serialName = "ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TimeoutErrorCause.Error>() as KSerializer<Any?>, fields = listOf("cause", "debug_info"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: TimeoutErrorCause) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): TimeoutErrorCause = union.deserialize(decoder)
}
