package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configuration for dynamic resharding feature
 */
@Serializable
public data class DynamicReshardingConfigView(
  /**
   *  * Maximum number of shards in the network.
   *
   * See [`CongestionControlConfig`] for more details.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_number_of_shards")
  public val maxNumberOfShards: ULong,
  /**
   *  * Memory threshold over which a shard is marked for a split.
   *
   * See [`CongestionControlConfig`] for more details.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("memory_usage_threshold")
  public val memoryUsageThreshold: ULong,
  /**
   *  * Minimum memory usage of a child shard.
   *
   * See [`CongestionControlConfig`] for more details.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("min_child_memory_usage")
  public val minChildMemoryUsage: ULong,
  /**
   *  * Minimum number of epochs until next resharding can be scheduled.
   *
   * See [`CongestionControlConfig`] for more details.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("min_epochs_between_resharding")
  public val minEpochsBetweenResharding: ULong,
)
