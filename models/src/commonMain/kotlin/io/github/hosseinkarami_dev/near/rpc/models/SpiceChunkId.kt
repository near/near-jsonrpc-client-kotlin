package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * In spice missing chunks and equivalent to empty chunks so block hash and shard id always
 * uniquely identifies chunks.
 */
@Serializable
public data class SpiceChunkId(
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  @SerialName("shard_id")
  public val shardId: ShardId,
)
