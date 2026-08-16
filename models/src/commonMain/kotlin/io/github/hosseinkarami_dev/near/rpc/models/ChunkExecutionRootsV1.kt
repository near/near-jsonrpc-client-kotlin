package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ChunkExecutionRootsV1(
  @SerialName("chunk_id")
  public val chunkId: SpiceChunkId,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  @SerialName("outgoing_receipts_root")
  public val outgoingReceiptsRoot: CryptoHash,
  @SerialName("state_root")
  public val stateRoot: CryptoHash,
)
