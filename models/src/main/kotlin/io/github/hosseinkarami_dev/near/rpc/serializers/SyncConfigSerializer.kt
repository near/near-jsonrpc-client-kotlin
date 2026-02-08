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
import io.github.hosseinkarami_dev.near.rpc.models.SyncConfig

object SyncConfigSerializer : KSerializer<SyncConfig> {
    private val union: BlindUnionSerializer<SyncConfig> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.SyncConfig",
        variants = listOf(
            Variant(serialName = "Peers", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.Peers),
            Variant(serialName = "ExternalStorage", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage).externalStorage }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.SyncConfig.ExternalStorage(it as io.github.hosseinkarami_dev.near.rpc.models.ExternalStorageConfig) }, fields = listOf("ExternalStorage"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: SyncConfig) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): SyncConfig = union.deserialize(decoder)
}
