package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Create a `0u` universal account from its state init. The receiver id must
 * equal `derive_universal_account_id(state_init)`; the attached `deposit`
 * covers the new account's storage staking.
 *
 * The state init travels as the bytes the producer serialized, because the
 * receiver id commits to exactly those bytes. The typed [`UniversalStateInit`]
 * is a decoded view of them, used where the state has to be installed or priced.
 */
@Serializable
public data class UniversalStateInitAction(
  @SerialName("deposit")
  public val deposit: NearToken,
  @SerialName("state_init")
  public val stateInit: RawStateInit,
)
