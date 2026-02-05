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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError

object JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoErrorSerializer : KSerializer<JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError = union.deserialize(decoder)
}
