package io.github.hosseinkarami_dev.near.rpc.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer
import io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView
import kotlinx.serialization.json.*

object GlobalContractIdentifierViewSerializer : KSerializer<GlobalContractIdentifierView> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView") {
        element("hash", serializer<JsonElement>().descriptor)
        element("account_id", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: GlobalContractIdentifierView) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["hash"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), value.hash)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): GlobalContractIdentifierView {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for GlobalContractIdentifierView")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing GlobalContractIdentifierView")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("hash", "account_id")
                    if (jobj["hash"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.CryptoHash>(), jobj["hash"]!!))
                    }
                    if (jobj["account_id"] != null) {
                        return io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId(decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["account_id"]!!))
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "hash" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant hash: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>(), obj)
                            }
                            "account_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant account_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = emptyList<String>()
                    if (typeField == null) {
                        for ((k, v) in jobj.entries) {
                            if (v is JsonPrimitive && v.isString) {
                                val s = v.content
                                if (knownVariantNames.any { it.equals(s, ignoreCase = true) }) { typeField = s; break }
                            }
                        }
                    }

                    if (typeField != null) {
                        val tf = typeField.trim()
                        // try exact match of full variant name first
                        when (tf) {
                            "hash" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>(), jobj)
                            "account_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("hash".lowercase() == tfLower || tfLower.contains("hash".lowercase()) || "hash".lowercase().contains(tfLower))) { chosenGroupKey = "hash" }
                        if (chosenGroupKey == null && ("account_id".lowercase() == tfLower || tfLower.contains("account_id".lowercase()) || "account_id".lowercase().contains(tfLower))) { chosenGroupKey = "account_id" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "hash" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'hash' and tf='\$tf'")
                                }
                                "account_id" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'account_id' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: hash
                    // group: account_id

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("hash")) requiredMatches.add(0)
                    if (jobj.containsKey("account_id")) requiredMatches.add(1)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["hash"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["account_id"] != null) matchCount++
                        val score = matchCount.toDouble() / 1.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.Hash>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.GlobalContractIdentifierView.AccountId>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in GlobalContractIdentifierView")
                }
            }
        }
        throw SerializationException("Cannot deserialize GlobalContractIdentifierView with non-JSON decoder")
    }
}
