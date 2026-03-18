package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.NonceModeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Controls how the transaction nonce is validated against the access key nonce.
 */
@Serializable(with = NonceModeSerializer::class)
public sealed class NonceMode {
  /**
   *  * Any nonce strictly greater than the current access key nonce (default behavior).
   *  * Possible values: monotonic
   */
  @Serializable
  @SerialName("monotonic")
  public data object Monotonic : NonceMode()

  /**
   *  * Nonce must be exactly `ak_nonce + 1` (sequential ordering).
   *  * Possible values: strict
   */
  @Serializable
  @SerialName("strict")
  public data object Strict : NonceMode()
}
