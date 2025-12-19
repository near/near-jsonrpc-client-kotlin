package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalViewState(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_view_state
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcViewStateRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_view_state
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_view_state")
    EXPERIMENTAL_VIEW_STATE,
  }
}
