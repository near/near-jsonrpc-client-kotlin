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
import io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError

object FunctionCallErrorSerializer : KSerializer<FunctionCallError> {
    private val union: BlindUnionSerializer<FunctionCallError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError",
        variants = listOf(
            Variant(serialName = "WasmUnknownError", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmUnknownError),
            Variant(serialName = "_EVMError", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.EVMError),
            Variant(serialName = "CompilationError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError).compilationError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.CompilationError(it as io.github.hosseinkarami_dev.near.rpc.models.CompilationError) }, fields = listOf("CompilationError")),
            Variant(serialName = "LinkError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError.LinkErrorPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError).linkError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError(it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.LinkError.LinkErrorPayload) }, fields = listOf("LinkError")),
            Variant(serialName = "MethodResolveError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError).methodResolveError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.MethodResolveError(it as io.github.hosseinkarami_dev.near.rpc.models.MethodResolveError) }, fields = listOf("MethodResolveError")),
            Variant(serialName = "WasmTrap", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.WasmTrap>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap).wasmTrap }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.WasmTrap(it as io.github.hosseinkarami_dev.near.rpc.models.WasmTrap) }, fields = listOf("WasmTrap")),
            Variant(serialName = "HostError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.HostError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError).hostError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.HostError(it as io.github.hosseinkarami_dev.near.rpc.models.HostError) }, fields = listOf("HostError")),
            Variant(serialName = "ExecutionError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError>() as KSerializer<Any?>, valueSerializer = serializer<kotlin.String>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError).executionError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.FunctionCallError.ExecutionError(it as kotlin.String) }, fields = listOf("ExecutionError"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: FunctionCallError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): FunctionCallError = union.deserialize(decoder)
}
