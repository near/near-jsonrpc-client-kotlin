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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError

object JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofErrorSerializer : KSerializer<JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError = union.deserialize(decoder)
}
