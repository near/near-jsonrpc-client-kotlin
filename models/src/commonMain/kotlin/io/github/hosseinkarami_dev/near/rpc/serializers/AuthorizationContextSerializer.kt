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
import io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext

object AuthorizationContextSerializer : KSerializer<AuthorizationContext> {
    private val union: BlindUnionSerializer<AuthorizationContext> = BlindUnionSerializer(
        serialName = "io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext",
        variants = listOf(
            Variant(serialName = "ExternalContractCall", kind = VariantKind.OBJECT, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext.ExternalContractCall }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext.ExternalContractCall>() as KSerializer<Any?>, objectInstance = io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext.ExternalContractCall),
            Variant(serialName = "AccessKey", kind = VariantKind.WRAPPED, isInstance = { it is io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext.AccessKey }, fullSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext.AccessKey>() as KSerializer<Any?>, valueSerializer = serializer<io.github.hosseinkarami_dev.near.rpc.models.PublicKey>() as KSerializer<Any?>, valueGetter = { (it as io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext.AccessKey).accessKey }, valueBuilder = { io.github.hosseinkarami_dev.near.rpc.models.AuthorizationContext.AccessKey(it as io.github.hosseinkarami_dev.near.rpc.models.PublicKey) }, fields = listOf("AccessKey"))
        )
    )

    override val descriptor = union.descriptor
    override fun serialize(encoder: Encoder, value: AuthorizationContext) = union.serialize(encoder, value)
    override fun deserialize(decoder: Decoder): AuthorizationContext = union.deserialize(decoder)
}
