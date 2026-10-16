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
import io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView

object TransactionEnvelopeViewSerializer : KSerializer<TransactionEnvelopeView> {
    private val union: BlindUnionSerializer<TransactionEnvelopeView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView",
        variants = listOf(
            Variant(serialName = "SignedTransactionView", kind = VariantKind.VALUE, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.SignedTransactionView }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.SignedTransactionView>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.SignedTransactionView).value }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.SignedTransactionView(it as io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView) }, fields = listOf("SignedTransactionView")),
            Variant(serialName = "EccTransactionView", kind = VariantKind.VALUE, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.EccTransactionView }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.EccTransactionView>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.EccTransactionView>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.EccTransactionView).value }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.EccTransactionView(it as io.github.hosseinkarami_dev.near.rpc.models.EccTransactionView) }, fields = listOf("EccTransactionView"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: TransactionEnvelopeView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): TransactionEnvelopeView = union.deserialize(decoder)
}
