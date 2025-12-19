package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcViewGasKeyListResponseAndRpcViewGasKeyListErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcViewGasKeyListResponseAndRpcViewGasKeyListErrorSerializer::class)
public sealed class JsonRpcResponseForRpcViewGasKeyListResponseAndRpcViewGasKeyListError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcViewGasKeyListResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewGasKeyListResponseAndRpcViewGasKeyListError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcViewGasKeyListError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewGasKeyListResponseAndRpcViewGasKeyListError()
}
