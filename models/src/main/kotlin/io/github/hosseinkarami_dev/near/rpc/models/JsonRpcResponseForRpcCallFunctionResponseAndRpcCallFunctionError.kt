package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionErrorSerializer::class)
public sealed class JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcCallFunctionResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcCallFunctionError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionError()
}
