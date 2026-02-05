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
import io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView

object ReceiptEnumViewSerializer : KSerializer<ReceiptEnumView> {
    private val union: BlindUnionSerializer<ReceiptEnumView> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView",
        variants = listOf(
            Variant(serialName = "Action", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action.ActionPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action).action }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action(it as io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Action.ActionPayload) }, fields = listOf("Action")),
            Variant(serialName = "Data", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data.DataPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data).data }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data(it as io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.Data.DataPayload) }, fields = listOf("Data")),
            Variant(serialName = "GlobalContractDistribution", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution.GlobalContractDistributionPayload>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution).globalContractDistribution }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution(it as io.github.hosseinkarami_dev.near.rpc.models.ReceiptEnumView.GlobalContractDistribution.GlobalContractDistributionPayload) }, fields = listOf("GlobalContractDistribution"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: ReceiptEnumView) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): ReceiptEnumView = union.deserialize(decoder)
}
