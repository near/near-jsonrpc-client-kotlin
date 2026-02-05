package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalCallFunction(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_call_function
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcCallFunctionRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_call_function
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_call_function")
    EXPERIMENTAL_CALL_FUNCTION,
  }
}
