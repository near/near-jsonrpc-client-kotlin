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
import io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation

object ExternalStorageLocationSerializer : KSerializer<ExternalStorageLocation> {
    private val union: BlindUnionSerializer<ExternalStorageLocation> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation",
        variants = listOf(
            Variant(serialName = "S3", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3.S3Payload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3).s3 }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3(it as io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.S3.S3Payload) }, fields = listOf("S3")),
            Variant(serialName = "Filesystem", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem.FilesystemPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem).filesystem }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem(it as io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Filesystem.FilesystemPayload) }, fields = listOf("Filesystem")),
            Variant(serialName = "GCS", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs.GcsPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs).gcs }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs(it as io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageLocation.Gcs.GcsPayload) }, fields = listOf("GCS"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: ExternalStorageLocation) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): ExternalStorageLocation = union.deserialize(decoder)
}
