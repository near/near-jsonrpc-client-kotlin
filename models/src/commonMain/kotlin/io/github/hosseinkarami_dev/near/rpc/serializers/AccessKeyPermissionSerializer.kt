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
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission

object AccessKeyPermissionSerializer : KSerializer<AccessKeyPermission> {
    private val union: BlindUnionSerializer<AccessKeyPermission> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission",
        variants = listOf(
            Variant(serialName = "FunctionCall", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall).functionCall }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FunctionCall(it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallPermission) }, fields = listOf("FunctionCall")),
            Variant(serialName = "FullAccess", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.FullAccess),
            Variant(serialName = "GasKeyFunctionCall", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFunctionCall }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFunctionCall>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFunctionCall.GasKeyFunctionCallTuple>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFunctionCall).gasKeyFunctionCall }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFunctionCall(it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFunctionCall.GasKeyFunctionCallTuple) }, fields = listOf("GasKeyFunctionCall")),
            Variant(serialName = "GasKeyFullAccess", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFullAccess }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFullAccess>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.GasKeyInfo>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFullAccess).gasKeyFullAccess }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermission.GasKeyFullAccess(it as io.github.hosseinkarami_dev.near.rpc.models.GasKeyInfo) }, fields = listOf("GasKeyFullAccess"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: AccessKeyPermission) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): AccessKeyPermission = union.deserialize(decoder)
}
