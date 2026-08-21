package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalLightClientStateProof(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_light_client_state_proof
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcLightClientStateProofRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_light_client_state_proof
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_light_client_state_proof")
    EXPERIMENTAL_LIGHT_CLIENT_STATE_PROOF,
  }
}
