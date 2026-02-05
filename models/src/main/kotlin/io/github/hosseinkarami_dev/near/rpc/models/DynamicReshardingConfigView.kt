package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configuration for dynamic resharding feature
 * See [`DynamicReshardingConfig`] for more details.
 */
@Serializable
public data class DynamicReshardingConfigView(
  /**
   *  * Shards that should **not** be split even when they meet the regular split criteria.
   */
  @SerialName("block_split_shards")
  public val blockSplitShards: List<ShardId>,
  /**
   *  * Shards that should be split even when they don't meet the regular split criteria.
   */
  @SerialName("force_split_shards")
  public val forceSplitShards: List<ShardId>,
  /**
   *  * Maximum number of shards in the network.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_of_shards")
  public val maxNumberOfShards: ULong,
  /**
   *  * Memory threshold over which a shard is marked for a split.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("memory_usage_threshold")
  public val memoryUsageThreshold: ULong,
  /**
   *  * Minimum memory usage of a child shard.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("min_child_memory_usage")
  public val minChildMemoryUsage: ULong,
  /**
   *  * Minimum number of epochs until next resharding can be scheduled.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("min_epochs_between_resharding")
  public val minEpochsBetweenResharding: ULong,
)
