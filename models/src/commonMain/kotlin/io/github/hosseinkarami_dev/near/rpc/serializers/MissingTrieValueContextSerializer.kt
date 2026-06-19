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
import io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext

object MissingTrieValueContextSerializer : KSerializer<MissingTrieValueContext> {
    private val union: BlindUnionSerializer<MissingTrieValueContext> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext",
        variants = listOf(
            Variant(serialName = "TrieIterator", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieIterator),
            Variant(serialName = "TriePrefetchingStorage", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TriePrefetchingStorage),
            Variant(serialName = "TrieMemoryPartialStorage", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieMemoryPartialStorage),
            Variant(serialName = "TrieStorage", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValueContext.TrieStorage)
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: MissingTrieValueContext) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): MissingTrieValueContext = union.deserialize(decoder)
}
