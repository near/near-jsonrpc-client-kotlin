package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UShort
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class GasKeyInfo(
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
