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
import io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest
import kotlinx.serialization.json.*

object RpcCallFunctionRequestSerializer : KSerializer<RpcCallFunctionRequest> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest") {
        element("block_id", serializer<JsonElement>().descriptor)
        element("finality", serializer<JsonElement>().descriptor)
        element("sync_checkpoint", serializer<JsonElement>().descriptor)
    }

    override fun serialize(encoder: Encoder, value: RpcCallFunctionRequest) {
         if (encoder is JsonEncoder) {
            val jsonEncoder = encoder
            when (value) {
                is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["block_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), value.blockId)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), value.argsBase64)
                    map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.methodName)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["finality"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), value.finality)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), value.argsBase64)
                    map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.methodName)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
                is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint -> {
                    val map = mutableMapOf<String, JsonElement>()
                    map["sync_checkpoint"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), value.syncCheckpoint)
                    map["account_id"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), value.accountId)
                    map["args_base64"] = jsonEncoder.json.encodeToJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), value.argsBase64)
                    map["method_name"] = jsonEncoder.json.encodeToJsonElement(serializer<kotlin.String>(), value.methodName)
                    val payload = JsonObject(map)
                    jsonEncoder.encodeJsonElement(payload)
                }
            }
            return
        }
        val out = encoder.beginStructure(descriptor)
        when (value) {
            is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId -> out.encodeSerializableElement(descriptor, 0, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality -> out.encodeSerializableElement(descriptor, 1, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>(), value)
            is io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint -> out.encodeSerializableElement(descriptor, 2, serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>(), value)
        }
        out.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): RpcCallFunctionRequest {
        if (decoder is JsonDecoder) {
            val element = decoder.decodeJsonElement()
            when (element) {
                is JsonPrimitive -> {
                    if (element.isString) {
                        val s = element.content
                    }
                    throw SerializationException("Unknown discriminator (primitive) for RpcCallFunctionRequest")
                }

                is JsonArray -> throw SerializationException("Unexpected JSON array while deserializing RpcCallFunctionRequest")

                is JsonObject -> {
                    val jobj = element
                    val knownVariantNames = setOf("block_id", "finality", "sync_checkpoint")
                    if (jobj["block_id"] != null) {
                        val blockIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.BlockId>(), jobj["block_id"] ?: throw SerializationException("Missing field 'block_id' for variant BlockId"))
                        val accountIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant BlockId"))
                        val argsBase64Val = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), jobj["args_base64"] ?: throw SerializationException("Missing field 'args_base64' for variant BlockId"))
                        val methodNameVal = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["method_name"] ?: throw SerializationException("Missing field 'method_name' for variant BlockId"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId(blockIdVal, accountIdVal, argsBase64Val, methodNameVal)
                    }
                    if (jobj["finality"] != null) {
                        val finalityVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.Finality>(), jobj["finality"] ?: throw SerializationException("Missing field 'finality' for variant Finality"))
                        val accountIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant Finality"))
                        val argsBase64Val = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), jobj["args_base64"] ?: throw SerializationException("Missing field 'args_base64' for variant Finality"))
                        val methodNameVal = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["method_name"] ?: throw SerializationException("Missing field 'method_name' for variant Finality"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality(finalityVal, accountIdVal, argsBase64Val, methodNameVal)
                    }
                    if (jobj["sync_checkpoint"] != null) {
                        val syncCheckpointVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint>(), jobj["sync_checkpoint"] ?: throw SerializationException("Missing field 'sync_checkpoint' for variant SyncCheckpoint"))
                        val accountIdVal = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.AccountId>(), jobj["account_id"] ?: throw SerializationException("Missing field 'account_id' for variant SyncCheckpoint"))
                        val argsBase64Val = decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.FunctionArgs>(), jobj["args_base64"] ?: throw SerializationException("Missing field 'args_base64' for variant SyncCheckpoint"))
                        val methodNameVal = decoder.json.decodeFromJsonElement(serializer<kotlin.String>(), jobj["method_name"] ?: throw SerializationException("Missing field 'method_name' for variant SyncCheckpoint"))
                        return io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint(syncCheckpointVal, accountIdVal, argsBase64Val, methodNameVal)
                    }
                    if (jobj.size == 1) {
                        val entry = jobj.entries.first()
                        val key = entry.key
                        val valueElem = entry.value
                        if (knownVariantNames.contains(key)) {
                            when (key) {
                            "block_id" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant block_id: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>(), obj)
                            }
                            "finality" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant finality: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>(), obj)
                            }
                            "sync_checkpoint" -> {
                                val obj = valueElem as? JsonObject ?: throw SerializationException("Expected object payload for variant sync_checkpoint: " + key)
                                return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>(), obj)
                            }
                            else -> { /* knownVariantNames.contains(key) guards this branch; shouldn't reach here */ }
                            }
                        }
                    }
                    var typeField: String? = null
                    val discriminatorCandidates = listOf("method_name")
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
                            "block_id" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>(), jobj)
                            "finality" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>(), jobj)
                            "sync_checkpoint" -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>(), jobj)
                            else -> { /* fallthrough to grouped handling */ }
                        }
                        // grouped handling by tf content (if any)
                        val tfLower = tf.lowercase()
                        var chosenGroupKey: String? = null
                        if (chosenGroupKey == null && ("block_id".lowercase() == tfLower || tfLower.contains("block_id".lowercase()) || "block_id".lowercase().contains(tfLower))) { chosenGroupKey = "block_id" }
                        if (chosenGroupKey == null && ("finality".lowercase() == tfLower || tfLower.contains("finality".lowercase()) || "finality".lowercase().contains(tfLower))) { chosenGroupKey = "finality" }
                        if (chosenGroupKey == null && ("sync_checkpoint".lowercase() == tfLower || tfLower.contains("sync_checkpoint".lowercase()) || "sync_checkpoint".lowercase().contains(tfLower))) { chosenGroupKey = "sync_checkpoint" }
                        if (chosenGroupKey != null) {
                            when (chosenGroupKey) {
                                "block_id" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'block_id' and tf='\$tf'")
                                }
                                "finality" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'finality' and tf='\$tf'")
                                }
                                "sync_checkpoint" -> {
                                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>(), jobj) } catch (_: Exception) { }
                                    throw SerializationException("Cannot disambiguate variant for base token 'sync_checkpoint' and tf='\$tf'")
                                }
                                else -> { /* no group matched */ }
                            }
                        }
                    }
                    // grouped handling by presence of distinguishing keys (no discriminator value available)
                    // group: block_id
                    // group: finality
                    // group: sync_checkpoint

                    val requiredMatches = mutableListOf<Int>()
                    if (jobj.containsKey("block_id") && jobj.containsKey("account_id") && jobj.containsKey("args_base64") && jobj.containsKey("method_name")) requiredMatches.add(0)
                    if (jobj.containsKey("finality") && jobj.containsKey("account_id") && jobj.containsKey("args_base64") && jobj.containsKey("method_name")) requiredMatches.add(1)
                    if (jobj.containsKey("sync_checkpoint") && jobj.containsKey("account_id") && jobj.containsKey("args_base64") && jobj.containsKey("method_name")) requiredMatches.add(2)
                    if (requiredMatches.size == 1) {
                        when (requiredMatches[0]) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal required-match dispatch error")
                        }
                    }
                    var bestIdx: Int? = null
                    var bestScore = -1.0
                    run {
                        var matchCount = 0
                        if (jobj["block_id"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["args_base64"] != null) matchCount++
                        if (jobj["method_name"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 0 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["finality"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["args_base64"] != null) matchCount++
                        if (jobj["method_name"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 1 } else if (score == bestScore) { bestIdx = null }
                    }
                    run {
                        var matchCount = 0
                        if (jobj["sync_checkpoint"] != null) matchCount++
                        if (jobj["account_id"] != null) matchCount++
                        if (jobj["args_base64"] != null) matchCount++
                        if (jobj["method_name"] != null) matchCount++
                        val score = matchCount.toDouble() / 4.toDouble()
                        if (score > bestScore) { bestScore = score; bestIdx = 2 } else if (score == bestScore) { bestIdx = null }
                    }
                    if (bestIdx != null && bestScore > 0.0) {
                        when (bestIdx) {
                            0 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>(), jobj)
                            1 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>(), jobj)
                            2 -> return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>(), jobj)
                            else -> throw SerializationException("Internal scoring dispatch error")
                        }
                    }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.BlockId>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.Finality>(), jobj) } catch (_: Exception) { }
                    try { return decoder.json.decodeFromJsonElement(serializer<io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest.SyncCheckpoint>(), jobj) } catch (_: Exception) { }
                    throw SerializationException("Missing discriminator or recognizable variant in RpcCallFunctionRequest")
                }
            }
        }
        throw SerializationException("Cannot deserialize RpcCallFunctionRequest with non-JSON decoder")
    }
}
