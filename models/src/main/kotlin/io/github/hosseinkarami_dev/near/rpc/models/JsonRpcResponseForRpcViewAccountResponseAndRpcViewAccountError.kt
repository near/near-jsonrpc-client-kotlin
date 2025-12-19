package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountErrorSerializer::class)
public sealed class JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcViewAccountResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcViewAccountError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountError()
}
