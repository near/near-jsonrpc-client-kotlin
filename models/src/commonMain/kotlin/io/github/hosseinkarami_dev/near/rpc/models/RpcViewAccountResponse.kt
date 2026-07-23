package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A view of the account
 */
@Serializable
public data class RpcViewAccountResponse(
  /**
   *  * Liquid (non-staked) account balance, in yoctoNEAR.
   */
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
  /**
   *  * Hash of the deployed contract code; the all-`1`s hash when no contract is deployed.
   */
  @SerialName("code_hash")
  public val codeHash: CryptoHash,
  /**
   *  * Set when the account uses a global contract referenced by the deploying account id.
   */
  @SerialName("global_contract_account_id")
  public val globalContractAccountId: AccountId? = null,
  /**
   *  * Set when the account uses a global contract referenced by code hash.
   */
  @SerialName("global_contract_hash")
  public val globalContractHash: CryptoHash? = null,
  /**
   *  * Staked balance locked for validation, in yoctoNEAR.
   */
  @SerialName("locked")
  public val locked: NearToken,
  /**
   *  * Deprecated and unused. TODO(2271): remove.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("storage_paid_at")
  public val storagePaidAt: ULong? = 0.toULong(),
  /**
   *  * Total storage used by the account, in bytes.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("storage_usage")
  public val storageUsage: ULong,
)
