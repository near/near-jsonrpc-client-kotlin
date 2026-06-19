package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListErrorSerializer::class)
public sealed class JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcViewAccessKeyListResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcViewAccessKeyListError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListError()
}
