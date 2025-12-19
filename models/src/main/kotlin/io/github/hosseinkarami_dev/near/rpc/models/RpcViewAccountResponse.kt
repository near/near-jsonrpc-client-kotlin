package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A view of the account
 */
@Serializable
public data class RpcViewAccountResponse(
  @SerialName("amount")
  public val amount: NearToken,
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_height")
  public val blockHeight: ULong,
  @SerialName("code_hash")
  public val codeHash: CryptoHash,
  @SerialName("global_contract_account_id")
  public val globalContractAccountId: AccountId? = null,
  @SerialName("global_contract_hash")
  public val globalContractHash: CryptoHash? = null,
  @SerialName("locked")
  public val locked: NearToken,
  /**
   *  * TODO(2271): deprecated.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("storage_paid_at")
  public val storagePaidAt: ULong? = 0.toULong(),
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("storage_usage")
  public val storageUsage: ULong,
)
