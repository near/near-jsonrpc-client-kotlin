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
import io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind

object RpcRequestValidationErrorKindSerializer : KSerializer<RpcRequestValidationErrorKind> {
    private val union: BlindUnionSerializer<RpcRequestValidationErrorKind> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind",
        variants = listOf(
            Variant(serialName = "METHOD_NOT_FOUND", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind.MethodNotFound }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind.MethodNotFound>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "PARSE_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind.ParseError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcRequestValidationErrorKind.ParseError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcRequestValidationErrorKind) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcRequestValidationErrorKind = union.deserialize(decoder)
}
