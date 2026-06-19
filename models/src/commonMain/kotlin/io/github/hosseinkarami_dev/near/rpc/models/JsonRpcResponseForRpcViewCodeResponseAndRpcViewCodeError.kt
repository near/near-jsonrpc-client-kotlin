package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeErrorSerializer::class)
public sealed class JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcViewCodeResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcViewCodeError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeError()
}
