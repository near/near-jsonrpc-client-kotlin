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
import io.github.hosseinkarami_dev.near.rpc.models.StateInitView

object StateInitViewSerializer : KSerializer<StateInitView> {
    private val union: BlindUnionSerializer<StateInitView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.StateInitView",
        variants = listOf(
            Variant(serialName = "deterministic", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Deterministic }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Deterministic>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Deterministic.DeterministicPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Deterministic).deterministic }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Deterministic(it as io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Deterministic.DeterministicPayload) }, fields = listOf("deterministic")),
            Variant(serialName = "universal", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Universal }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Universal>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RawStateInit>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Universal).universal }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.StateInitView.Universal(it as io.github.hosseinkarami_dev.near.rpc.models.RawStateInit) }, fields = listOf("universal"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: StateInitView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): StateInitView = union.deserialize(decoder)
}
