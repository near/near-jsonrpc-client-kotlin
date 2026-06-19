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
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError

object RpcValidatorErrorSerializer : KSerializer<RpcValidatorError> {
    private val union: BlindUnionSerializer<RpcValidatorError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_EPOCH", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError.UnknownEpoch }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError.UnknownEpoch>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "VALIDATOR_INFO_UNAVAILABLE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError.ValidatorInfoUnavailable }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError.ValidatorInfoUnavailable>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcValidatorError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcValidatorError = union.deserialize(decoder)
}
