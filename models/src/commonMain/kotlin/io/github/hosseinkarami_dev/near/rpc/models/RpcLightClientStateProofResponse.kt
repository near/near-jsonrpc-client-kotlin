package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcLightClientStateProofResponse(
  @SerialName("chunk_execution_proof")
  public val chunkExecutionProof: ChunkExecutionProofView,
  @SerialName("state_proof")
  public val stateProof: StateProofView,
)
