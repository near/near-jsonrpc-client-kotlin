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
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError
import kotlinx.serialization.json.*

object RpcViewStateErrorSerializer : KSerializer<RpcViewStateError> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError") {
        element("UNKNOWN_BLOCK", serializer<JsonElement>().descriptor)
        element("INVALID_ACCOUNT", serializer<JsonElement>().descriptor)
        element("UNKNOWN_ACCOUNT", serializer<JsonElement>().descriptor)
        element("TOO_LARGE_CONTRACT_STATE", serializer<JsonElement>().descriptor)
        element("INTERNAL_ERROR", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcViewStateError) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["info"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError.InfoPayload>(), value.info)
                    map["name"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError.Name>(), value.name)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState -> out.encodeSerializableElement(descriptor, 3, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError -> out.encodeSerializableElement(descriptor, 4, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcViewStateError {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcViewStateError")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcViewStateError")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("UNKNOWN_BLOCK", "INVALID_ACCOUNT", "UNKNOWN_ACCOUNT", "TOO_LARGE_CONTRACT_STATE", "INTERNAL_ERROR")
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "UNKNOWN_BLOCK" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_BLOCK: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock>(), obj)
                            }
                            "INVALID_ACCOUNT" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INVALID_ACCOUNT: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount>(), obj)
                            }
                            "UNKNOWN_ACCOUNT" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant UNKNOWN_ACCOUNT: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount>(), obj)
                            }
                            "TOO_LARGE_CONTRACT_STATE" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant TOO_LARGE_CONTRACT_STATE: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState>(), obj)
                            }
                            "INTERNAL_ERROR" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant INTERNAL_ERROR: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError>(), obj)
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
                            "UNKNOWN_BLOCK" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock>(), jobj)
                            "INVALID_ACCOUNT" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount>(), jobj)
                            "UNKNOWN_ACCOUNT" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount>(), jobj)
                            "TOO_LARGE_CONTRACT_STATE" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState>(), jobj)
                            "INTERNAL_ERROR" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("UNKNOWN_BLOCK".lowercase() == tfLower || tfLower.contains("UNKNOWN_BLOCK".lowercase()) || "UNKNOWN_BLOCK".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_BLOCK" }
                        if (chosenGroupKey == null && ("INVALID_ACCOUNT".lowercase() == tfLower || tfLower.contains("INVALID_ACCOUNT".lowercase()) || "INVALID_ACCOUNT".lowercase().contains(tfLower))) { chosenGroupKey = "INVALID_ACCOUNT" }
                        if (chosenGroupKey == null && ("UNKNOWN_ACCOUNT".lowercase() == tfLower || tfLower.contains("UNKNOWN_ACCOUNT".lowercase()) || "UNKNOWN_ACCOUNT".lowercase().contains(tfLower))) { chosenGroupKey = "UNKNOWN_ACCOUNT" }
                        if (chosenGroupKey == null && ("TOO_LARGE_CONTRACT_STATE".lowercase() == tfLower || tfLower.contains("TOO_LARGE_CONTRACT_STATE".lowercase()) || "TOO_LARGE_CONTRACT_STATE".lowercase().contains(tfLower))) { chosenGroupKey = "TOO_LARGE_CONTRACT_STATE" }
                        if (chosenGroupKey == null && ("INTERNAL_ERROR".lowercase() == tfLower || tfLower.contains("INTERNAL_ERROR".lowercase()) || "INTERNAL_ERROR".lowercase().contains(tfLower))) { chosenGroupKey = "INTERNAL_ERROR" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "UNKNOWN_BLOCK" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_BLOCK' and tf='\$tf'")
                                }
                                "INVALID_ACCOUNT" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'INVALID_ACCOUNT' and tf='\$tf'")
                                }
                                "UNKNOWN_ACCOUNT" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'UNKNOWN_ACCOUNT' and tf='\$tf'")
                                }
                                "TOO_LARGE_CONTRACT_STATE" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'TOO_LARGE_CONTRACT_STATE' and tf='\$tf'")
                                }
                                "INTERNAL_ERROR" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError>(), jobj) } catch (_: Exception) { }
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
                    // group: TOO_LARGE_CONTRACT_STATE
                    // group: INTERNAL_ERROR

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(0)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(1)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(2)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(3)
                    if (jobj.containsKey("info") && jobj.containsKey("name")) requiredMatches.add(4)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError>(), jobj)
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
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount>(), jobj)
                            3 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState>(), jobj)
                            4 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownBlock>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InvalidAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.UnknownAccount>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.TooLargeContractState>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateError.InternalError>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcViewStateError")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcViewStateError with non-JSON decoder")
    }
}
