package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An external call as a chunk holds it. Its unique id is unknown in a chunk that no block on the
 * canonical chain includes.
 */
@Serializable
public data class ChunkEccTransactionView(
  @SerialName("contract_id")
  public val contractId: AccountId,
  @SerialName("payload")
  public val payload: String,
  /**
   *  * The universal account state init the call carries.
   *  * Nullable: true
   */
  @SerialName("state_init")
  public val stateInit: String? = null,
  /**
   *  * The unique id of this copy of the call, its outcome id. `None` when no block on the
   * canonical chain includes the chunk.
   */
  @SerialName("transaction_id")
  public val transactionId: CryptoHash? = null,
)
