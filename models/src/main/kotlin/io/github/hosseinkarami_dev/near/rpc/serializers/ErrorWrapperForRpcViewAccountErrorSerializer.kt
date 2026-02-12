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
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError

object ErrorWrapperForRpcViewAccountErrorSerializer : KSerializer<ErrorWrapperForRpcViewAccountError> {
    private val union: BlindUnionSerializer<ErrorWrapperForRpcViewAccountError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError",
        variants = listOf(
            Variant(serialName = "REQUEST_VALIDATION_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError.RequestValidationError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError.RequestValidationError>() as KSerializer<Any?>, fields = listOf("cause", "name")),
            Variant(serialName = "HANDLER_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError.HandlerError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError.HandlerError>() as KSerializer<Any?>, fields = listOf("cause", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError.InternalError>() as KSerializer<Any?>, fields = listOf("cause", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: ErrorWrapperForRpcViewAccountError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): ErrorWrapperForRpcViewAccountError = union.deserialize(decoder)
}
