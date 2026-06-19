package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcViewAccountRequestSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcViewAccountRequestSerializer::class)
public sealed class RpcViewAccountRequest {
  @Serializable
  public data class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
  ) : RpcViewAccountRequest()

  @Serializable
  public data class Finality(
    @SerialName("finality")
    public val finality: io.github.hosseinkarami_dev.near.rpc.models.Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
  ) : RpcViewAccountRequest()

  @Serializable
  public data class SyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
  ) : RpcViewAccountRequest()
}
