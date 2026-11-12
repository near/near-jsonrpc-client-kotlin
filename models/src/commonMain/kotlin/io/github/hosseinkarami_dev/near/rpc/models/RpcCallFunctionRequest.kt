package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcCallFunctionRequestSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcCallFunctionRequestSerializer::class)
public sealed class RpcCallFunctionRequest {
  @Serializable
  public data class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    /**
     *  * Runs the call as if this were installed, unless the account already has its state.
     */
    @SerialName("state_init")
    public val stateInit: StateInitView? = null,
  ) : RpcCallFunctionRequest()

  @Serializable
  public data class Finality(
    @SerialName("finality")
    public val finality: io.github.hosseinkarami_dev.near.rpc.models.Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    /**
     *  * Runs the call as if this were installed, unless the account already has its state.
     */
    @SerialName("state_init")
    public val stateInit: StateInitView? = null,
  ) : RpcCallFunctionRequest()

  @Serializable
  public data class SyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("args_base64")
    public val argsBase64: FunctionArgs,
    @SerialName("method_name")
    public val methodName: String,
    /**
     *  * Runs the call as if this were installed, unless the account already has its state.
     */
    @SerialName("state_init")
    public val stateInit: StateInitView? = null,
  ) : RpcCallFunctionRequest()
}
