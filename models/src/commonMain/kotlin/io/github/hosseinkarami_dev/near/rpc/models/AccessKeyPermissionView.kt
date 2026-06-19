package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.AccessKeyPermissionViewSerializer
import kotlin.String
import kotlin.UShort
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes the permission scope for an access key. Whether it is a function call or a full access key.
 */
@Serializable(with = AccessKeyPermissionViewSerializer::class)
public sealed class AccessKeyPermissionView {
  /**
   *  * Possible values: FullAccess
   */
  @Serializable
  @SerialName("FullAccess")
  public data object FullAccess : AccessKeyPermissionView()

  @Serializable
  public data class FunctionCall(
    @SerialName("FunctionCall")
    public val functionCall: FunctionCallPayload,
  ) : AccessKeyPermissionView() {
    @Serializable
    public data class FunctionCallPayload(
      @SerialName("allowance")
      public val allowance: NearToken? = null,
      @SerialName("method_names")
      public val methodNames: List<String>,
      @SerialName("receiver_id")
      public val receiverId: String,
    )
  }

  @Serializable
  public data class GasKeyFunctionCall(
    @SerialName("GasKeyFunctionCall")
    public val gasKeyFunctionCall: GasKeyFunctionCallPayload,
  ) : AccessKeyPermissionView() {
    @Serializable
    public data class GasKeyFunctionCallPayload(
      @SerialName("allowance")
      public val allowance: NearToken? = null,
      @SerialName("balance")
      public val balance: NearToken,
      @SerialName("method_names")
      public val methodNames: List<String>,
      /**
       *  * Minimum: 0.0
       *  * Maximum: 65535.0
       *  * Format: uint16
       */
      @SerialName("num_nonces")
      public val numNonces: UShort,
      @SerialName("receiver_id")
      public val receiverId: String,
    )
  }

  @Serializable
  public data class GasKeyFullAccess(
    @SerialName("GasKeyFullAccess")
    public val gasKeyFullAccess: GasKeyFullAccessPayload,
  ) : AccessKeyPermissionView() {
    @Serializable
    public data class GasKeyFullAccessPayload(
      @SerialName("balance")
      public val balance: NearToken,
      /**
       *  * Minimum: 0.0
       *  * Maximum: 65535.0
       *  * Format: uint16
       */
      @SerialName("num_nonces")
      public val numNonces: UShort,
    )
  }
}
