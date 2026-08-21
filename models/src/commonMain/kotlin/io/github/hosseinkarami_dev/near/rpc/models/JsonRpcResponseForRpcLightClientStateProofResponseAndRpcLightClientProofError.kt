package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofErrorSerializer::class)
public sealed class JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcLightClientStateProofResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcLightClientProofError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientStateProofResponseAndRpcLightClientProofError()
}
