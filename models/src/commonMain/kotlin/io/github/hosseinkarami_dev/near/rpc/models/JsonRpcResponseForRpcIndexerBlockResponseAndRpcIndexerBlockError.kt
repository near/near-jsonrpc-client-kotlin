package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcIndexerBlockResponseAndRpcIndexerBlockErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcIndexerBlockResponseAndRpcIndexerBlockErrorSerializer::class)
public sealed class JsonRpcResponseForRpcIndexerBlockResponseAndRpcIndexerBlockError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcIndexerBlockResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcIndexerBlockResponseAndRpcIndexerBlockError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcIndexerBlockError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcIndexerBlockResponseAndRpcIndexerBlockError()
}
