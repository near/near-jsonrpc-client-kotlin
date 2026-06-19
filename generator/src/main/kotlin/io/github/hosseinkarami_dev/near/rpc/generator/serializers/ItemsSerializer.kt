package io.github.hosseinkarami_dev.near.rpc.generator.serializers

import io.github.hosseinkarami_dev.near.rpc.generator.ItemsDefinition
import io.github.hosseinkarami_dev.near.rpc.generator.Schema
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject

object ItemsSerializer : KSerializer<ItemsDefinition> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("ItemsDefinition", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: ItemsDefinition) {
        val jsonEncoder = encoder as? kotlinx.serialization.json.JsonEncoder
        if (jsonEncoder == null) {
            when (value) {
                is ItemsDefinition.Single ->
                    encoder.encodeSerializableValue(Schema.serializer(), value.schema)
                is ItemsDefinition.Tuple ->
                    encoder.encodeSerializableValue(
                        kotlinx.serialization.builtins.ListSerializer(Schema.serializer()),
                        value.schemas
                    )
            }
            return
        }

        val element = when (value) {
            is ItemsDefinition.Single ->
                Json.encodeToJsonElement(Schema.serializer(), value.schema)
            is ItemsDefinition.Tuple ->
                JsonArray(value.schemas.map { Json.encodeToJsonElement(Schema.serializer(), it) })
        }
        jsonEncoder.encodeJsonElement(element)
    }

    override fun deserialize(decoder: Decoder): ItemsDefinition {
        val jsonDecoder = decoder as? JsonDecoder
            ?: throw SerializationException("ItemsSerializer requires JsonDecoder")
        val element = jsonDecoder.decodeJsonElement()
        return when (element) {
            is JsonArray -> {
                val schemas = element.map { Json.decodeFromJsonElement(Schema.serializer(), it) }
                ItemsDefinition.Tuple(schemas)
            }
            is JsonObject -> ItemsDefinition.Single(Json.decodeFromJsonElement(Schema.serializer(), element))
            else -> throw SerializationException("Unsupported items value: $element")
        }
    }
}
