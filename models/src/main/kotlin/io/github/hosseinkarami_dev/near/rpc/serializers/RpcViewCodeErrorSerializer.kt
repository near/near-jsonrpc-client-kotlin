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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError

object RpcViewCodeErrorSerializer : KSerializer<RpcViewCodeError> {
    private val union: BlindUnionSerializer<RpcViewCodeError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INVALID_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.InvalidAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.InvalidAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.UnknownAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.UnknownAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "NO_CONTRACT_CODE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.NoContractCode }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.NoContractCode>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcViewCodeError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcViewCodeError = union.deserialize(decoder)
}
