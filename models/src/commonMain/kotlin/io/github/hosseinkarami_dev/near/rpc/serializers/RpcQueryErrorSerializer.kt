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
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError

object RpcQueryErrorSerializer : KSerializer<RpcQueryError> {
    private val union: BlindUnionSerializer<RpcQueryError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError",
        variants = listOf(
            Variant(serialName = "NO_SYNCED_BLOCKS", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoSyncedBlocks>() as KSerializer<Any?>, fields = listOf("name")),
            Variant(serialName = "UNAVAILABLE_SHARD", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnavailableShard>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "GARBAGE_COLLECTED_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.GarbageCollectedBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_BLOCK", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownBlock>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INVALID_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InvalidAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_ACCOUNT", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccount>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "NO_CONTRACT_CODE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoContractCode>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "TOO_LARGE_CONTRACT_STATE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooLargeContractState>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_ACCESS_KEY", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownAccessKey>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "UNKNOWN_GAS_KEY", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.UnknownGasKey>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "TOO_MANY_ACCESS_KEYS", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooManyAccessKeys }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.TooManyAccessKeys>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "CONTRACT_EXECUTION_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.ContractExecutionError>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "NO_GLOBAL_CONTRACT_CODE", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.NoGlobalContractCode>() as KSerializer<Any?>, fields = listOf("info", "name")),
            Variant(serialName = "INTERNAL_ERROR", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryError.InternalError>() as KSerializer<Any?>, fields = listOf("info", "name"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcQueryError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcQueryError = union.deserialize(decoder)
}
