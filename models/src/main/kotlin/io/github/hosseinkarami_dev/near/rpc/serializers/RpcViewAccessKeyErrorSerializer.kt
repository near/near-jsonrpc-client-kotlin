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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError
import kotlinx.serialization.json.*

object RpcViewAccessKeyErrorSerializer : KSerializer<RpcViewAccessKeyError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError") {
        element("UNKNOWN_BLOCK", serializer<JsonElement>().descriptor)
        element("INVALID_ACCOUNT", serializer<JsonElement>().descriptor)
        element("UNKNOWN_ACCOUNT", serializer<JsonElement>().descriptor)
        element("UNKNOWN_ACCESS_KEY", serializer<JsonElement>().descriptor)
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcViewAccessKeyError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcViewAccessKeyError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcViewAccessKeyError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcViewAccessKeyError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("UNKNOWN_BLOCK", "INVALID_ACCOUNT", "UNKNOWN_ACCOUNT", "UNKNOWN_ACCESS_KEY", "INTERNAL_ERROR")
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "UNKNOWN_BLOCK" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_BLOCK: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>(), obj)
                            }
                            "INVALID_ACCOUNT" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INVALID_ACCOUNT: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>(), obj)
                            }
                            "UNKNOWN_ACCOUNT" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_ACCOUNT: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>(), obj)
                            }
                            "UNKNOWN_ACCESS_KEY" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_ACCESS_KEY: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>(), obj)
                            }
                            "INTERNAL_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INTERNAL_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("info", "name")
                    for (cand in discriminatorCandidates) {
                        val candElem = jobj[cand]
                        if (candElem is JsonPrimitive) {
                            typeField = candElem.contentOrNull
                            if (typeField != null) break
                        }
                    }
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
                            "UNKNOWN_BLOCK" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>(), jobj)
                            "INVALID_ACCOUNT" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>(), jobj)
                            "UNKNOWN_ACCOUNT" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>(), jobj)
                            "UNKNOWN_ACCESS_KEY" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>(), jobj)
                            "INTERNAL_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("UNKNOWN_BLOCK".lowercase() == tfLower || tfLower.contains("UNKNOWN_BLOCK".lowercase()) || "UNKNOWN_BLOCK".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_BLOCK" }
                        if (chosenGroupKey == null && ("INVALID_ACCOUNT".lowercase() == tfLower || tfLower.contains("INVALID_ACCOUNT".lowercase()) || "INVALID_ACCOUNT".lowercase().contains(tfLower))) { chosenGroupKey = "INVALID_ACCOUNT" }
                        if (chosenGroupKey == null && ("UNKNOWN_ACCOUNT".lowercase() == tfLower || tfLower.contains("UNKNOWN_ACCOUNT".lowercase()) || "UNKNOWN_ACCOUNT".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_ACCOUNT" }
                        if (chosenGroupKey == null && ("UNKNOWN_ACCESS_KEY".lowercase() == tfLower || tfLower.contains("UNKNOWN_ACCESS_KEY".lowercase()) || "UNKNOWN_ACCESS_KEY".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_ACCESS_KEY" }
                        if (chosenGroupKey == null && ("INTERNAL_ERROR".lowercase() == tfLower || tfLower.contains("INTERNAL_ERROR".lowercase()) || "INTERNAL_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "INTERNAL_ERROR" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "UNKNOWN_BLOCK" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_BLOCK' and tf='\$tf'")
                                }
                                "INVALID_ACCOUNT" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INVALID_ACCOUNT' and tf='\$tf'")
                                }
                                "UNKNOWN_ACCOUNT" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_ACCOUNT' and tf='\$tf'")
                                }
                                "UNKNOWN_ACCESS_KEY" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_ACCESS_KEY' and tf='\$tf'")
                                }
                                "INTERNAL_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INTERNAL_ERROR' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: UNKNOWN_BLOCK
                    // group: INVALID_ACCOUNT
                    // group: UNKNOWN_ACCOUNT
                    // group: UNKNOWN_ACCESS_KEY
                    // group: INTERNAL_ERROR

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(0)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(1)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(2)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(3)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(4)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 3 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["info"] != null) matchCount++
                        if (jobj["name"] != null) matchCount++
                        val score = matchCount.toDouble() / 2.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 4 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InvalidAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.UnknownAccessKey>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyError.InternalError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcViewAccessKeyError")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcViewAccessKeyError with non-JSON decoder")
    }
}
