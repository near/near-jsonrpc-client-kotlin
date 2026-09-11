package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Resulting struct represents block with chunks
 */
@Serializable
public data class RpcIndexerBlockResponse(
  @SerialName("block")
  public val block: BlockView,
  @SerialName("shards")
  public val shards: List<IndexerShard>,
  /**
   *  * The node's configured chunk and execution coverage, in block layout order.
   * Carried chunks remain None inside the message even for tracked shards.
   */
  @SerialName("tracked_shards")
  public val trackedShards: List<ShardId>,
)
