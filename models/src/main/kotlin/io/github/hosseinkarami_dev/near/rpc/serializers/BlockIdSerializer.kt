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
import io.github.hosseinkarami_dev.near.rpc.models.BlockId

object BlockIdSerializer : KSerializer<BlockId> {
    private val union: BlindUnionSerializer<BlockId> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.BlockId",
        variants = listOf(
            Variant(serialName = "block_height", kind = VariantKind.VALUE, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight>() as KSerializer<Any?>, valueSerializer = serializer<kotlin.ULong>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight).value }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.BlockId.BlockHeight(it as kotlin.ULong) }, fields = listOf("block_height")),
            Variant(serialName = "CryptoHash", kind = VariantKind.VALUE, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash).value }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.BlockId.CryptoHash(it as io.github.hosseinkarami_dev.near.rpc.models.CryptoHash) }, fields = listOf("CryptoHash"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: BlockId) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): BlockId = union.deserialize(decoder)
}
