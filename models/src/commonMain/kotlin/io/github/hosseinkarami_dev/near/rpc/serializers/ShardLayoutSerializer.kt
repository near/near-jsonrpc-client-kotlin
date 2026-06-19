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
import io.github.hosseinkarami_dev.near.rpc.models.ShardLayout

object ShardLayoutSerializer : KSerializer<ShardLayout> {
    private val union: BlindUnionSerializer<ShardLayout> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.ShardLayout",
        variants = listOf(
            Variant(serialName = "V0", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0).v0 }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V0(it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV0) }, fields = listOf("V0")),
            Variant(serialName = "V1", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1).v1 }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V1(it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV1) }, fields = listOf("V1")),
            Variant(serialName = "V2", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2).v2 }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V2(it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV2) }, fields = listOf("V2")),
            Variant(serialName = "V3", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V3 }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V3>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV3>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V3).v3 }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ShardLayout.V3(it as io.github.hosseinkarami_dev.near.rpc.models.ShardLayoutV3) }, fields = listOf("V3"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: ShardLayout) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): ShardLayout = union.deserialize(decoder)
}
