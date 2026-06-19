package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalViewAccount(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_view_account
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcViewAccountRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_view_account
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_view_account")
    EXPERIMENTAL_VIEW_ACCOUNT,
  }
}
