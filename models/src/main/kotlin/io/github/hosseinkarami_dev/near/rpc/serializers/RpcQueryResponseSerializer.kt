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
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse

object RpcQueryResponseSerializer : KSerializer<RpcQueryResponse> {
    private val union: BlindUnionSerializer<RpcQueryResponse> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse",
        variants = listOf(
            Variant(serialName = "AccountView", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccountView>() as KSerializer<Any?>, fields = listOf("amount", "code_hash", "global_contract_account_id", "global_contract_hash", "locked", "storage_paid_at", "storage_usage", "block_hash", "block_height")),
            Variant(serialName = "ContractCodeView", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ContractCodeView>() as KSerializer<Any?>, fields = listOf("code_base64", "hash", "block_hash", "block_height")),
            Variant(serialName = "ViewStateResult", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.ViewStateResult>() as KSerializer<Any?>, fields = listOf("proof", "values", "block_hash", "block_height")),
            Variant(serialName = "CallResult", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.CallResult>() as KSerializer<Any?>, fields = listOf("logs", "result", "block_hash", "block_height")),
            Variant(serialName = "AccessKeyView", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyView>() as KSerializer<Any?>, fields = listOf("nonce", "permission", "block_hash", "block_height")),
            Variant(serialName = "AccessKeyList", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.AccessKeyList>() as KSerializer<Any?>, fields = listOf("keys", "block_hash", "block_height")),
            Variant(serialName = "block_hash_block_height", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.BlockHashBlockHeight }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse.BlockHashBlockHeight>() as KSerializer<Any?>, fields = listOf("block_hash", "block_height"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: RpcQueryResponse) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): RpcQueryResponse = union.deserialize(decoder)
}
