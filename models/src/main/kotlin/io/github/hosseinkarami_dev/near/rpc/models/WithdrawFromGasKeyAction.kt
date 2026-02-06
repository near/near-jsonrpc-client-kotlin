package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Withdraw NEAR from a gas key's balance to the account
 */
@Serializable
public data class WithdrawFromGasKeyAction(
  /**
   *  * Amount of NEAR to transfer from the gas key
   */
  @SerialName("amount")
  public val amount: NearToken,
  /**
   *  * The public key of the gas key to withdraw from
   */
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
