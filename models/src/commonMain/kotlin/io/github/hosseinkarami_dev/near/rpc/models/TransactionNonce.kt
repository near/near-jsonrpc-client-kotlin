package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.TransactionNonceSerializer
import kotlin.ULong
import kotlin.UShort
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = TransactionNonceSerializer::class)
public sealed class TransactionNonce {
  /**
   *  * Simple nonce without index, used by ordinary access keys
   */
  @Serializable
  public data class Nonce(
    @SerialName("Nonce")
    public val nonce: NoncePayload,
  ) : TransactionNonce() {
    @Serializable
    public data class NoncePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("nonce")
      public val nonce: ULong,
    )
  }

  /**
   *  * Nonce with index, used by gas keys
   */
  @Serializable
  public data class GasKeyNonce(
    @SerialName("GasKeyNonce")
    public val gasKeyNonce: GasKeyNoncePayload,
  ) : TransactionNonce() {
    @Serializable
    public data class GasKeyNoncePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("nonce")
      public val nonce: ULong,
      /**
       *  * Minimum: 0.0
       *  * Maximum: 65535.0
       *  * Format: uint16
       */
      @SerialName("nonce_index")
      public val nonceIndex: UShort,
    )
  }
}
