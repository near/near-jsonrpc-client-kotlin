package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class IndexerShard(
  @SerialName("chunk")
  public val chunk: IndexerChunkView? = null,
  @SerialName("receipt_execution_outcomes")
  public val receiptExecutionOutcomes: List<IndexerExecutionOutcomeWithReceipt>,
  @SerialName("shard_id")
  public val shardId: ShardId,
  @SerialName("state_changes")
  public val stateChanges: List<StateChangeWithCauseView>,
)
