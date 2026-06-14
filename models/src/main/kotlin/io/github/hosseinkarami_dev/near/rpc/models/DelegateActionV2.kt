package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Delegate action with gas key support: `nonce` selects either the access
 * key's nonce or one of a gas key's parallel nonces by index, mirroring
 * `TransactionV1`.
 */
@Serializable
public data class DelegateActionV2(
  /**
   *  * List of actions to be executed.
   */
  @SerialName("actions")
  public val actions: List<NonDelegateAction>,
  /**
   *  * The maximal height of the block in the blockchain below which the given DelegateActionV2 is valid.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_block_height")
  public val maxBlockHeight: ULong,
  /**
   *  * Nonce of the signing key, advanced when this action is processed. For
   * a gas key it also selects which of the parallel nonces to advance.
   */
  @SerialName("nonce")
  public val nonce: TransactionNonce,
  /**
   *  * Public key used to sign this delegated action.
   */
  @SerialName("public_key")
  public val publicKey: PublicKey,
  /**
   *  * Receiver of the delegated actions.
   */
  @SerialName("receiver_id")
  public val receiverId: AccountId,
  /**
   *  * Signer of the delegated actions
   */
  @SerialName("sender_id")
  public val senderId: AccountId,
)
