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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError

object JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoErrorSerializer : KSerializer<JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError = union.deserialize(decoder)
}
