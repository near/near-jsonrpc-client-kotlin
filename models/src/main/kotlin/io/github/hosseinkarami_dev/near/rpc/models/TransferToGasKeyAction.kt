package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Transfer NEAR to a gas key's balance
 */
@Serializable
public data class TransferToGasKeyAction(
  /**
   *  * Amount of NEAR to transfer to the gas key
   */
  @SerialName("deposit")
  public val deposit: NearToken,
  /**
   *  * The public key of the gas key to fund
   */
  @SerialName("public_key")
  public val publicKey: PublicKey,
)
