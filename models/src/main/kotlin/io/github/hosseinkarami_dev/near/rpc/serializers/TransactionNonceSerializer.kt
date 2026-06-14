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
import io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce

object TransactionNonceSerializer : KSerializer<TransactionNonce> {
    private val union: BlindUnionSerializer<TransactionNonce> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce",
        variants = listOf(
            Variant(serialName = "Nonce", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.Nonce }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.Nonce>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.Nonce.NoncePayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.Nonce).nonce }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.Nonce(it as io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.Nonce.NoncePayload) }, fields = listOf("Nonce")),
            Variant(serialName = "GasKeyNonce", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.GasKeyNonce }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.GasKeyNonce>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.GasKeyNonce.GasKeyNoncePayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.GasKeyNonce).gasKeyNonce }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.GasKeyNonce(it as io.github.hosseinkarami_dev.near.rpc.models.TransactionNonce.GasKeyNonce.GasKeyNoncePayload) }, fields = listOf("GasKeyNonce"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: TransactionNonce) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): TransactionNonce = union.deserialize(decoder)
}
