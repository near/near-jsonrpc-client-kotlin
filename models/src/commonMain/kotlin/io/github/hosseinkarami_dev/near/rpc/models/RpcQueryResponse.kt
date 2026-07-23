package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcQueryResponseSerializer
import kotlin.String
import kotlin.UByte
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcQueryResponseSerializer::class)
public sealed class RpcQueryResponse {
  @Serializable
  public data class AccountView(
    /**
     *  * Liquid (non-staked) account balance, in yoctoNEAR.
     */
    @SerialName("amount")
    public val amount: NearToken,
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
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class ContractCodeView(
    @SerialName("code_base64")
    public val codeBase64: String,
    @SerialName("hash")
    public val hash: CryptoHash,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class ViewStateResult(
    /**
     *  * Cursor to resume from: present when more entries remain, absent when the listing is complete.
     */
    @SerialName("last_key")
    public val lastKey: StoreKey? = null,
    @SerialName("proof")
    public val proof: List<String>? = null,
    @SerialName("values")
    public val values: List<StateItem>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class CallResult(
    @SerialName("logs")
    public val logs: List<String>,
    @SerialName("result")
    public val result: List<UByte>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class AccessKeyView(
    /**
     *  * Current nonce; each transaction signed with this key must use a strictly greater value.
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("nonce")
    public val nonce: ULong,
    /**
     *  * Access scope: full access, or a function-call permission with an optional allowance and method/receiver limits.
     */
    @SerialName("permission")
    public val permission: AccessKeyPermissionView,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class AccessKeyList(
    @SerialName("keys")
    public val keys: List<AccessKeyInfoView>,
    /**
     *  * Pagination cursor. When `Some`, the listing was truncated and the caller
     * should issue another request with `after_key` set to this handle to fetch
     * the next page. `None` means this was the last page.
     */
    @SerialName("last_key")
    public val lastKey: PublicKeyHandle? = null,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()

  @Serializable
  public data class GasKeyNoncesView(
    @SerialName("nonces")
    public val nonces: List<ULong>,
    @SerialName("block_hash")
    public val blockHash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("block_height")
    public val blockHeight: ULong,
  ) : RpcQueryResponse()
}
