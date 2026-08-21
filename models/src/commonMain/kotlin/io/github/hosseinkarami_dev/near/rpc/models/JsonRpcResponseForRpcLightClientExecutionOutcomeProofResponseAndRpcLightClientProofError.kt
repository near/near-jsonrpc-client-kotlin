package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.JsonRpcResponseForRpcLightClientExecutionOutcomeProofResponseAndRpcLightClientProofErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = JsonRpcResponseForRpcLightClientExecutionOutcomeProofResponseAndRpcLightClientProofErrorSerializer::class)
public sealed class JsonRpcResponseForRpcLightClientExecutionOutcomeProofResponseAndRpcLightClientProofError {
  @Serializable
  public data class Result(
    @SerialName("result")
    public val result: RpcLightClientExecutionOutcomeProofResponse,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientExecutionOutcomeProofResponseAndRpcLightClientProofError()

  @Serializable
  public data class Error(
    @SerialName("error")
    public val error: ErrorWrapperForRpcLightClientProofError,
    @SerialName("id")
    public val id: String,
    @SerialName("jsonrpc")
    public val jsonrpc: String,
  ) : JsonRpcResponseForRpcLightClientExecutionOutcomeProofResponseAndRpcLightClientProofError()
}
