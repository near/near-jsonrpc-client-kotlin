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
import io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus

object FinalExecutionStatusSerializer : KSerializer<FinalExecutionStatus> {
    private val union: BlindUnionSerializer<FinalExecutionStatus> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus",
        variants = listOf(
            Variant(serialName = "NotStarted", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.NotStarted),
            Variant(serialName = "Started", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Started),
            Variant(serialName = "Failure", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure).failure }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.Failure(it as io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError) }, fields = listOf("Failure")),
            Variant(serialName = "SuccessValue", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue>() as KSerializer<Any?>, valueSerializer = serializer<kotlin.String>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue).successValue }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FinalExecutionStatus.SuccessValue(it as kotlin.String) }, fields = listOf("SuccessValue"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: FinalExecutionStatus) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): FinalExecutionStatus = union.deserialize(decoder)
}
