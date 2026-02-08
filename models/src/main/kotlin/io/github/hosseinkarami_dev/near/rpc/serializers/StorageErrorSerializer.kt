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
import io.github.hosseinkarami_dev.near.rpc.models.StorageError

object StorageErrorSerializer : KSerializer<StorageError> {
    private val union: BlindUnionSerializer<StorageError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.StorageError",
        variants = listOf(
            Variant(serialName = "StorageInternalError", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInternalError),
            Variant(serialName = "MissingTrieValue", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue).missingTrieValue }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.StorageError.MissingTrieValue(it as io.github.hosseinkarami_dev.near.rpc.models.MissingTrieValue) }, fields = listOf("MissingTrieValue")),
            Variant(serialName = "UnexpectedTrieValue", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.StorageError.UnexpectedTrieValue),
            Variant(serialName = "StorageInconsistentState", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState>() as KSerializer<Any?>, valueSerializer = serializer<kotlin.String>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState).storageInconsistentState }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.StorageError.StorageInconsistentState(it as kotlin.String) }, fields = listOf("StorageInconsistentState")),
            Variant(serialName = "FlatStorageBlockNotSupported", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported>() as KSerializer<Any?>, valueSerializer = serializer<kotlin.String>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported).flatStorageBlockNotSupported }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.StorageError.FlatStorageBlockNotSupported(it as kotlin.String) }, fields = listOf("FlatStorageBlockNotSupported")),
            Variant(serialName = "MemTrieLoadingError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError>() as KSerializer<Any?>, valueSerializer = serializer<kotlin.String>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError).memTrieLoadingError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.StorageError.MemTrieLoadingError(it as kotlin.String) }, fields = listOf("MemTrieLoadingError"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: StorageError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): StorageError = union.deserialize(decoder)
}
