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
import io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError

object TxExecutionErrorSerializer : KSerializer<TxExecutionError> {
    private val union: BlindUnionSerializer<TxExecutionError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError",
        variants = listOf(
            Variant(serialName = "ActionError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ActionError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError).actionError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.ActionError(it as io.github.hosseinkarami_dev.near.rpc.models.ActionError) }, fields = listOf("ActionError")),
            Variant(serialName = "InvalidTxError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError).invalidTxError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TxExecutionError.InvalidTxError(it as io.github.hosseinkarami_dev.near.rpc.models.InvalidTxError) }, fields = listOf("InvalidTxError"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: TxExecutionError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): TxExecutionError = union.deserialize(decoder)
}
