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
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError

object JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsErrorSerializer : KSerializer<JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError> {
    private val union: BlindUnionSerializer<JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError",
        variants = listOf(
            Variant(serialName = "result", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Result }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Result>() as KSerializer<Any?>, fields = listOf("result", "id", "jsonrpc")),
            Variant(serialName = "error", kind = VariantKind.DEFAULT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Error }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Error>() as KSerializer<Any?>, fields = listOf("error", "id", "jsonrpc"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError = union.deserialize(decoder)
}
