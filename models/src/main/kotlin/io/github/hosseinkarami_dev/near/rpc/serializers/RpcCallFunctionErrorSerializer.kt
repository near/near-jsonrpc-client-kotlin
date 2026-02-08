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
import io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError

object RpcCallFunctionErrorSerializer : KSerializer<RpcCallFunctionError> {
    private val union: BlindUnionSerializer<RpcCallFunctionError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError",
        variants = listOf(
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INVALID_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.InvalidAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.InvalidAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.UnknownAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.UnknownAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "NO_CONTRACT_CODE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.NoContractCode }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.NoContractCode>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "CONTRACT_EXECUTION_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.ContractExecutionError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.ContractExecutionError>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcCallFunctionError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcCallFunctionError = union.deserialize(decoder)
}
