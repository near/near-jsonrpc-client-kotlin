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
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest

object RpcTransactionStatusRequestSerializer : KSerializer<RpcTransactionStatusRequest> {
    private val union: BlindUnionSerializer<RpcTransactionStatusRequest> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest",
        variants = listOf(
            Variant(serialName = "signed_tx_base64", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SignedTxBase64>() as KSerializer<Any?>, fields = listOf("signed_tx_base64", "wait_until")),
            Variant(serialName = "sender_account_id", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest.SenderAccountId>() as KSerializer<Any?>, fields = listOf("sender_account_id", "tx_hash", "wait_until"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcTransactionStatusRequest) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcTransactionStatusRequest = union.deserialize(decoder)
}
