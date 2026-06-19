package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Resulting state values for a view state query request
 */
@Serializable
public data class RpcViewStateResponse(
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_height")
  public val blockHeight: ULong,
  @SerialName("last_key")
  public val lastKey: StoreKey? = null,
  @SerialName("proof")
  public val proof: List<String>? = null,
  @SerialName("values")
  public val values: List<StateItem>,
)
