package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcViewAccessKeyListRequestSerializer
import kotlin.UInt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcViewAccessKeyListRequestSerializer::class)
public sealed class RpcViewAccessKeyListRequest {
  @Serializable
  public data class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Pagination cursor: resume the listing strictly after this access key.
     * Pass the `last_key` returned by the previous page.
     */
    @SerialName("after_key")
    public val afterKey: PublicKeyHandle? = null,
    /**
     *  * Maximum number of access keys to return in this page.
     *  * Minimum: 1.0
     *  * Format: uint32
     *  * Nullable: true
     */
    @SerialName("limit")
    public val limit: UInt? = null,
  ) : RpcViewAccessKeyListRequest()

  @Serializable
  public data class Finality(
    @SerialName("finality")
    public val finality: io.github.hosseinkarami_dev.near.rpc.models.Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Pagination cursor: resume the listing strictly after this access key.
     * Pass the `last_key` returned by the previous page.
     */
    @SerialName("after_key")
    public val afterKey: PublicKeyHandle? = null,
    /**
     *  * Maximum number of access keys to return in this page.
     *  * Minimum: 1.0
     *  * Format: uint32
     *  * Nullable: true
     */
    @SerialName("limit")
    public val limit: UInt? = null,
  ) : RpcViewAccessKeyListRequest()

  @Serializable
  public data class SyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Pagination cursor: resume the listing strictly after this access key.
     * Pass the `last_key` returned by the previous page.
     */
    @SerialName("after_key")
    public val afterKey: PublicKeyHandle? = null,
    /**
     *  * Maximum number of access keys to return in this page.
     *  * Minimum: 1.0
     *  * Format: uint32
     *  * Nullable: true
     */
    @SerialName("limit")
    public val limit: UInt? = null,
  ) : RpcViewAccessKeyListRequest()
}
