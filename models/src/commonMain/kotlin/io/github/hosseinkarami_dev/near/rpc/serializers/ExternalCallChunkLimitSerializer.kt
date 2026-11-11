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
import io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit

object ExternalCallChunkLimitSerializer : KSerializer<ExternalCallChunkLimit> {
    private val union: BlindUnionSerializer<ExternalCallChunkLimit> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit",
        variants = listOf(
            Variant(serialName = "Compute", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.Compute }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.Compute>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.Compute.ComputePayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.Compute).compute }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.Compute(it as io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.Compute.ComputePayload) }, fields = listOf("Compute")),
            Variant(serialName = "StorageProof", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.StorageProof }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.StorageProof>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.StorageProof.StorageProofPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.StorageProof).storageProof }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.StorageProof(it as io.github.hosseinkarami_dev.near.rpc.models.ExternalCallChunkLimit.StorageProof.StorageProofPayload) }, fields = listOf("StorageProof"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: ExternalCallChunkLimit) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): ExternalCallChunkLimit = union.deserialize(decoder)
}
