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
import io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView

object AccessKeyPermissionViewSerializer : KSerializer<AccessKeyPermissionView> {
    private val union: BlindUnionSerializer<AccessKeyPermissionView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView",
        variants = listOf(
            Variant(serialName = "FullAccess", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FullAccess),
            Variant(serialName = "FunctionCall", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall.FunctionCallPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall).functionCall }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall(it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.FunctionCall.FunctionCallPayload) }, fields = listOf("FunctionCall")),
            Variant(serialName = "GasKeyFunctionCall", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFunctionCall }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFunctionCall>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFunctionCall.GasKeyFunctionCallPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFunctionCall).gasKeyFunctionCall }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFunctionCall(it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFunctionCall.GasKeyFunctionCallPayload) }, fields = listOf("GasKeyFunctionCall")),
            Variant(serialName = "GasKeyFullAccess", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFullAccess }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFullAccess>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFullAccess.GasKeyFullAccessPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFullAccess).gasKeyFullAccess }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFullAccess(it as io.github.hosseinkarami_dev.near.rpc.models.AccessKeyPermissionView.GasKeyFullAccess.GasKeyFullAccessPayload) }, fields = listOf("GasKeyFullAccess"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: AccessKeyPermissionView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): AccessKeyPermissionView = union.deserialize(decoder)
}
