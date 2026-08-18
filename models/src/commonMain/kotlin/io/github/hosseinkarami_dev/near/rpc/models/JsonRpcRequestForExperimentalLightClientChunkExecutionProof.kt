package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalLightClientChunkExecutionProof(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_light_client_chunk_execution_proof
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcLightClientChunkExecutionProofRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_light_client_chunk_execution_proof
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_light_client_chunk_execution_proof")
    EXPERIMENTAL_LIGHT_CLIENT_CHUNK_EXECUTION_PROOF,
  }
}
