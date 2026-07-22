package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcViewStateRequestSerializer
import kotlin.Boolean
import kotlin.UInt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcViewStateRequestSerializer::class)
public sealed class RpcViewStateRequest {
  @Serializable
  public data class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Resume listing after this key (exclusive); must start with `prefix`.
     */
    @SerialName("after_key_base64")
    public val afterKeyBase64: StoreKey? = null,
    @SerialName("include_proof")
    public val includeProof: Boolean? = false,
    /**
     *  * Maximum number of entries to return in this page.
     *  * Minimum: 1.0
     *  * Format: uint32
     *  * Nullable: true
     */
    @SerialName("limit")
    public val limit: UInt? = null,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
  ) : RpcViewStateRequest()

  @Serializable
  public data class Finality(
    @SerialName("finality")
    public val finality: io.github.hosseinkarami_dev.near.rpc.models.Finality,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Resume listing after this key (exclusive); must start with `prefix`.
     */
    @SerialName("after_key_base64")
    public val afterKeyBase64: StoreKey? = null,
    @SerialName("include_proof")
    public val includeProof: Boolean? = false,
    /**
     *  * Maximum number of entries to return in this page.
     *  * Minimum: 1.0
     *  * Format: uint32
     *  * Nullable: true
     */
    @SerialName("limit")
    public val limit: UInt? = null,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
  ) : RpcViewStateRequest()

  @Serializable
  public data class SyncCheckpoint(
    @SerialName("sync_checkpoint")
    public val syncCheckpoint: io.github.hosseinkarami_dev.near.rpc.models.SyncCheckpoint,
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Resume listing after this key (exclusive); must start with `prefix`.
     */
    @SerialName("after_key_base64")
    public val afterKeyBase64: StoreKey? = null,
    @SerialName("include_proof")
    public val includeProof: Boolean? = false,
    /**
     *  * Maximum number of entries to return in this page.
     *  * Minimum: 1.0
     *  * Format: uint32
     *  * Nullable: true
     */
    @SerialName("limit")
    public val limit: UInt? = null,
    @SerialName("prefix_base64")
    public val prefixBase64: StoreKey,
  ) : RpcViewStateRequest()
}
