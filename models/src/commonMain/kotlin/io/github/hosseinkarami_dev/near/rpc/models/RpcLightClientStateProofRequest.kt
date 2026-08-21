package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcLightClientStateProofRequest(
  @SerialName("chunk_id")
  public val chunkId: SpiceChunkId,
  @SerialName("light_client_head")
  public val lightClientHead: CryptoHash,
  @SerialName("target")
  public val target: StateProofTarget,
)
