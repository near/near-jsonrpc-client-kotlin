package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EccTransactionView(
  @SerialName("contract_id")
  public val contractId: AccountId,
  @SerialName("payload")
  public val payload: String,
  /**
   *  * The universal account state init this copy of the call carries.
   *  * Nullable: true
   */
  @SerialName("state_init")
  public val stateInit: String? = null,
  /**
   *  * The unique id of this copy of the call, its outcome id.
   */
  @SerialName("transaction_id")
  public val transactionId: CryptoHash,
)
