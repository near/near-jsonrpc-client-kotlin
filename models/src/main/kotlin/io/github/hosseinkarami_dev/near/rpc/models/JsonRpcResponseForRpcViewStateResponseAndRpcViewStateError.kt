package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcViewStateResponseAndRpcViewStateErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcViewStateResponseAndRpcViewStateErrorSerializer::class)
public sealed class JsonRpcResponseForRpcViewStateResponseAndRpcViewStateError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcViewStateResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewStateResponseAndRpcViewStateError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcViewStateError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewStateResponseAndRpcViewStateError()
}
