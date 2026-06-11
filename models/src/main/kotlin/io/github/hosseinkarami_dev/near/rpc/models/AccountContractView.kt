package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.AccountContractViewSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * RPC view of a non-empty [`AccountContract`]. The `AccountContract::None`
 * variant is represented externally as a JSON `null` via `Option`, so this
 * enum only carries the three "contract is present" cases. Serializes as
 * an externally-tagged object:
 *
 * - `Local(hash)` → `{"local": "<CryptoHash>"}`
 * - `GlobalHash(hash)` → `{"global_hash": "<CryptoHash>"}`
 * - `GlobalAccountId(id)` → `{"global_account_id": "<AccountId>"}`
 *
 * Mirrors [`AccountContract`] 1:1 (minus `None`) so consumers can preserve
 * the distinction between a global-by-hash and global-by-account contract
 * without descending into a nested identifier.
 */
@Serializable(with = AccountContractViewSerializer::class)
public sealed class AccountContractView {
  @Serializable
  public data class Local(
    @SerialName("local")
    public val local: CryptoHash,
  ) : AccountContractView()

  @Serializable
  public data class GlobalHash(
    @SerialName("global_hash")
    public val globalHash: CryptoHash,
  ) : AccountContractView()

  @Serializable
  public data class GlobalAccountId(
    @SerialName("global_account_id")
    public val globalAccountId: AccountId,
  ) : AccountContractView()
}
