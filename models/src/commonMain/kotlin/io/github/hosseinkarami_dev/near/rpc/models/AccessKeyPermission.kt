package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.AccessKeyPermissionSerializer
import kotlin.OptIn
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.serializer

/**
 *  * Defines permissions for AccessKey
 */
@Serializable(with = AccessKeyPermissionSerializer::class)
public sealed class AccessKeyPermission {
  @Serializable
  public data class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallPermission,
  ) : AccessKeyPermission()

  /**
   *  * Grants full access to the account.
   * NOTE: It's used to replace account-level public keys.
   *  * Possible values: FullAccess
   */
  @Serializable
  @SerialName("FullAccess")
  public data object FullAccess : AccessKeyPermission()

  /**
   *  * Gas key with limited permission to make transactions with FunctionCallActions
   * Gas keys are a kind of access keys with a prepaid balance to pay for gas.
   */
  @Serializable
  public data class GasKeyFunctionCall(
    /**
     *  * Min Items: 2
     *  * Max Items: 2
     */
    @SerialName("GasKeyFunctionCall")
    public val gasKeyFunctionCall: GasKeyFunctionCallTuple,
  ) : AccessKeyPermission() {
    /**
     *  * Min Items: 2
     *  * Max Items: 2
     */
    @Serializable(with = GasKeyFunctionCallTuple.TupleSerializer::class)
    public data class GasKeyFunctionCallTuple(
      public val item0: GasKeyInfo,
      public val item1: FunctionCallPermission,
    ) {
      @OptIn(InternalSerializationApi::class)
      public object TupleSerializer : KSerializer<GasKeyFunctionCallTuple> {
        override val descriptor: SerialDescriptor =
            buildSerialDescriptor("GasKeyFunctionCallTuple", StructureKind.LIST)

        override fun serialize(encoder: Encoder, `value`: GasKeyFunctionCallTuple) {
          if (encoder !is JsonEncoder) throw SerializationException("Cannot serialize GasKeyFunctionCallTuple with non-JSON encoder")
          val json = encoder.json
          val list = buildList<JsonElement> {
            add(json.encodeToJsonElement(serializer<GasKeyInfo>(), value.item0))
            add(json.encodeToJsonElement(serializer<FunctionCallPermission>(), value.item1))
          }
          encoder.encodeJsonElement(JsonArray(list))
        }

        override fun deserialize(decoder: Decoder): GasKeyFunctionCallTuple {
          if (decoder !is JsonDecoder) throw SerializationException("Cannot deserialize GasKeyFunctionCallTuple with non-JSON decoder")
          val element = decoder.decodeJsonElement()
          val arr = element as? JsonArray ?: throw SerializationException("Expected JSON array for GasKeyFunctionCallTuple")
          if (arr.size != 2) throw SerializationException("Expected 2 items for GasKeyFunctionCallTuple")
          val item0 = decoder.json.decodeFromJsonElement(serializer<GasKeyInfo>(), arr[0])
          val item1 = decoder.json.decodeFromJsonElement(serializer<FunctionCallPermission>(), arr[1])
          return GasKeyFunctionCallTuple(item0, item1)
        }
      }
    }
  }

  /**
   *  * Gas key with full access to the account.
   * Gas keys are a kind of access keys with a prepaid balance to pay for gas.
   */
  @Serializable
  public data class GasKeyFullAccess(
    @SerialName("GasKeyFullAccess")
    public val gasKeyFullAccess: GasKeyInfo,
  ) : AccessKeyPermission()
}
