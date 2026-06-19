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
import io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig

object TrackedShardsConfigSerializer : KSerializer<TrackedShardsConfig> {
    private val union: BlindUnionSerializer<TrackedShardsConfig> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig",
        variants = listOf(
            Variant(serialName = "NoShards", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.NoShards),
            Variant(serialName = "Shards", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards>() as KSerializer<Any?>, valueSerializer = ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardUId>()) as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards).shards }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Shards(it as kotlin.collections.List<io.github.hosseinkarami_dev.near.rpc.models.ShardUId>) }, fields = listOf("Shards")),
            Variant(serialName = "AllShards", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.AllShards),
            Variant(serialName = "ShadowValidator", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator).shadowValidator }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.ShadowValidator(it as io.github.hosseinkarami_dev.near.rpc.models.AccountId) }, fields = listOf("ShadowValidator")),
            Variant(serialName = "Schedule", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule>() as KSerializer<Any?>, valueSerializer = ListSerializer(ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardId>())) as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule).schedule }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Schedule(it as kotlin.collections.List<kotlin.collections.List<io.github.hosseinkarami_dev.near.rpc.models.ShardId>>) }, fields = listOf("Schedule")),
            Variant(serialName = "Accounts", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts>() as KSerializer<Any?>, valueSerializer = ListSerializer(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>()) as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts).accounts }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.TrackedShardsConfig.Accounts(it as kotlin.collections.List<io.github.hosseinkarami_dev.near.rpc.models.AccountId>) }, fields = listOf("Accounts"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: TrackedShardsConfig) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): TrackedShardsConfig = union.deserialize(decoder)
}
