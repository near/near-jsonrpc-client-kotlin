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
import io.github.hosseinkarami_dev.near.rpc.models.NonceMode

object NonceModeSerializer : KSerializer<NonceMode> {
    private val union: BlindUnionSerializer<NonceMode> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.NonceMode",
        variants = listOf(
            Variant(serialName = "monotonic", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.NonceMode.Monotonic }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.NonceMode.Monotonic>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.NonceMode.Monotonic),
            Variant(serialName = "strict", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.NonceMode.Strict }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.NonceMode.Strict>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.NonceMode.Strict)
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: NonceMode) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): NonceMode = union.deserialize(decoder)
}
