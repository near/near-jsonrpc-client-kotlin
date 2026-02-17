package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * The result of splitting a memtrie into two possibly even parts, according to `memory_usage`
 * stored in the trie nodes.
 *
 * **NOTE: This is an artificial value calculated according to `TRIE_COST`. Hence, it does not
 * represent actual memory allocation, but the split ratio should be roughly consistent with that.**
 */
@Serializable
public data class TrieSplit(
  /**
   *  * Account ID representing the split path
   */
  @SerialName("boundary_account")
  public val boundaryAccount: AccountId,
  /**
   *  * Total `memory_usage` of the left part (excluding the split path)
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("left_memory")
  public val leftMemory: ULong,
  /**
   *  * Total `memory_usage` of the right part (including the split path)
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("right_memory")
  public val rightMemory: ULong,
)
