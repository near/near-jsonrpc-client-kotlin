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
import io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError

object InvalidAccessKeyErrorSerializer : KSerializer<InvalidAccessKeyError> {
    private val union: BlindUnionSerializer<InvalidAccessKeyError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError",
        variants = listOf(
            Variant(serialName = "AccessKeyNotFound", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound.AccessKeyNotFoundPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound).accessKeyNotFound }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound(it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.AccessKeyNotFound.AccessKeyNotFoundPayload) }, fields = listOf("AccessKeyNotFound")),
            Variant(serialName = "ReceiverMismatch", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch.ReceiverMismatchPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch).receiverMismatch }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch(it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.ReceiverMismatch.ReceiverMismatchPayload) }, fields = listOf("ReceiverMismatch")),
            Variant(serialName = "MethodNameMismatch", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch.MethodNameMismatchPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch).methodNameMismatch }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch(it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.MethodNameMismatch.MethodNameMismatchPayload) }, fields = listOf("MethodNameMismatch")),
            Variant(serialName = "RequiresFullAccess", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.RequiresFullAccess),
            Variant(serialName = "NotEnoughAllowance", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance.NotEnoughAllowancePayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance).notEnoughAllowance }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance(it as io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.NotEnoughAllowance.NotEnoughAllowancePayload) }, fields = listOf("NotEnoughAllowance")),
            Variant(serialName = "DepositWithFunctionCall", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DepositWithFunctionCall),
            Variant(serialName = "DelegateActionRequiresNonGasKey", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DelegateActionRequiresNonGasKey }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DelegateActionRequiresNonGasKey>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError.DelegateActionRequiresNonGasKey)
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: InvalidAccessKeyError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): InvalidAccessKeyError = union.deserialize(decoder)
}
