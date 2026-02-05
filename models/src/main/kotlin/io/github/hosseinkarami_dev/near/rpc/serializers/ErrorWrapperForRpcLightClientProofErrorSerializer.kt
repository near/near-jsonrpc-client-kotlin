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
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError

object ErrorWrapperForRpcLightClientProofErrorSerializer : KSerializer<ErrorWrapperForRpcLightClientProofError> {
    private val union: BlindUnionSerializer<ErrorWrapperForRpcLightClientProofError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError",
        variants = listOf(
            Variant(serialName = "REQUEST_VALIDATION_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError.RequestValidationError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError.RequestValidationError>() as KSerializer<Any?>, fields = listOf("cause", "name")),
            Variant(serialName = "HANDLER_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError.HandlerError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError.HandlerError>() as KSerializer<Any?>, fields = listOf("cause", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError.InternalError>() as KSerializer<Any?>, fields = listOf("cause", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: ErrorWrapperForRpcLightClientProofError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): ErrorWrapperForRpcLightClientProofError = union.deserialize(decoder)
}
