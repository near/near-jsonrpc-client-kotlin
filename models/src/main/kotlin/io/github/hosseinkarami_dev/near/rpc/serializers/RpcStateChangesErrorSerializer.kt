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
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError

object RpcStateChangesErrorSerializer : KSerializer<RpcStateChangesError> {
    private val union: BlindUnionSerializer<RpcStateChangesError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "NOT_SYNCED_YET", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError.NotSyncedYet }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError.NotSyncedYet>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcStateChangesError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcStateChangesError = union.deserialize(decoder)
}
