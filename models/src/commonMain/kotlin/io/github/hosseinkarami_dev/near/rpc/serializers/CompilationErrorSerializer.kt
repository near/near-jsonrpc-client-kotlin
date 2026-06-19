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
import io.github.hosseinkarami_dev.near.rpc.models.CompilationError

object CompilationErrorSerializer : KSerializer<CompilationError> {
    private val union: BlindUnionSerializer<CompilationError> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.CompilationError",
        variants = listOf(
            Variant(serialName = "CodeDoesNotExist", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist.CodeDoesNotExistPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist).codeDoesNotExist }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist(it as io.github.hosseinkarami_dev.near.rpc.models.CompilationError.CodeDoesNotExist.CodeDoesNotExistPayload) }, fields = listOf("CodeDoesNotExist")),
            Variant(serialName = "PrepareError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.PrepareError>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError).prepareError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.CompilationError.PrepareError(it as io.github.hosseinkarami_dev.near.rpc.models.PrepareError) }, fields = listOf("PrepareError")),
            Variant(serialName = "WasmerCompileError", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError.WasmerCompileErrorPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError).wasmerCompileError }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError(it as io.github.hosseinkarami_dev.near.rpc.models.CompilationError.WasmerCompileError.WasmerCompileErrorPayload) }, fields = listOf("WasmerCompileError"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: CompilationError) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): CompilationError = union.deserialize(decoder)
}
