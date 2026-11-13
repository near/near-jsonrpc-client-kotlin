package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForNullableCryptoHashAndRpcTransactionErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForNullableCryptoHashAndRpcTransactionErrorSerializer::class)
public sealed class JsonRpcResponseForNullableCryptoHashAndRpcTransactionError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: CryptoHash? = null,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForNullableCryptoHashAndRpcTransactionError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcTransactionError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForNullableCryptoHashAndRpcTransactionError()
}
