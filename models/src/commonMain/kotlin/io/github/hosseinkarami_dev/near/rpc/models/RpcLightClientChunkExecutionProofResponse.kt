package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcLightClientChunkExecutionProofResponse(
  @SerialName("chunk_execution_proof")
  public val chunkExecutionProof: ChunkExecutionProofView,
)
