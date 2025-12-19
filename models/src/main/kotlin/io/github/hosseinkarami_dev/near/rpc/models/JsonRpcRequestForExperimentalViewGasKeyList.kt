package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalViewGasKeyList(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_view_gas_key_list
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcViewGasKeyListRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_view_gas_key_list
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_view_gas_key_list")
    EXPERIMENTAL_VIEW_GAS_KEY_LIST,
  }
}
