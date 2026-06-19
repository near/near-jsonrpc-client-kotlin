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
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus

object TxExecutionStatusSerializer : KSerializer<TxExecutionStatus> {
    private val union: BlindUnionSerializer<TxExecutionStatus> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus",
        variants = listOf(
            Variant(serialName = "NONE", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.None),
            Variant(serialName = "INCLUDED", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Included),
            Variant(serialName = "EXECUTED_OPTIMISTIC", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.ExecutedOptimistic),
            Variant(serialName = "INCLUDED_FINAL", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.IncludedFinal),
            Variant(serialName = "EXECUTED", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Executed),
            Variant(serialName = "FINAL", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TxExecutionStatus.Final)
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: TxExecutionStatus) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): TxExecutionStatus = union.deserialize(decoder)
}
