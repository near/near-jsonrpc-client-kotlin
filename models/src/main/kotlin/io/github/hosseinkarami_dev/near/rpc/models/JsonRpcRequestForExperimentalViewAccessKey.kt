package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalViewAccessKey(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_view_access_key
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcViewAccessKeyRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_view_access_key
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_view_access_key")
    EXPERIMENTAL_VIEW_ACCESS_KEY,
  }
}
