package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcLightClientChunkExecutionProofResponseAndRpcLightClientProofErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcLightClientChunkExecutionProofResponseAndRpcLightClientProofErrorSerializer::class)
public sealed class JsonRpcResponseForRpcLightClientChunkExecutionProofResponseAndRpcLightClientProofError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcLightClientChunkExecutionProofResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientChunkExecutionProofResponseAndRpcLightClientProofError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcLightClientProofError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientChunkExecutionProofResponseAndRpcLightClientProofError()
}
