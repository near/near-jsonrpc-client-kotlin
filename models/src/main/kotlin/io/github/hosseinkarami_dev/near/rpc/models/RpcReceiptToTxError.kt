package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcReceiptToTxErrorSerializer
import kotlin.String
import kotlin.UInt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcReceiptToTxErrorSerializer::class)
public sealed class RpcReceiptToTxError {
  @Serializable
  public data class UnknownReceipt(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_RECEIPT
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcReceiptToTxError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("receipt_id")
      public val receiptId: CryptoHash,
    )

    /**
     *  * Possible values: UNKNOWN_RECEIPT
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_RECEIPT")
      UNKNOWN_RECEIPT,
    }
  }

  @Serializable
  public data class DepthExceeded(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: DEPTH_EXCEEDED
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcReceiptToTxError() {
    @Serializable
    public data class InfoPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("limit")
      public val limit: UInt,
      @SerialName("receipt_id")
      public val receiptId: CryptoHash,
    )

    /**
     *  * Possible values: DEPTH_EXCEEDED
     */
    @Serializable
    public enum class Name {
      @SerialName("DEPTH_EXCEEDED")
      DEPTH_EXCEEDED,
    }
  }

  @Serializable
  public data class Unsupported(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNSUPPORTED
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcReceiptToTxError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: UNSUPPORTED
     */
    @Serializable
    public enum class Name {
      @SerialName("UNSUPPORTED")
      UNSUPPORTED,
    }
  }

  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcReceiptToTxError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("INTERNAL_ERROR")
      INTERNAL_ERROR,
    }
  }
}
