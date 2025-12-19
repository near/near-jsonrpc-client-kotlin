package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalViewCode(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_view_code
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcViewCodeRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_view_code
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_view_code")
    EXPERIMENTAL_VIEW_CODE,
  }
}
