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
            Variant(serialName = "signed", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.Signed }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.Signed>() as KSerializer<Any?>, fields = listOf("actions", "hash", "nonce", "nonce_index", "nonce_mode", "priority_fee", "public_key", "receiver_id", "signature", "signer_id", "kind")),
            Variant(serialName = "external_call", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.ExternalCall }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionEnvelopeView.ExternalCall>() as KSerializer<Any?>, fields = listOf("contract_id", "payload", "state_init", "transaction_id", "kind"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: TransactionEnvelopeView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): TransactionEnvelopeView = union.deserialize(decoder)
}
