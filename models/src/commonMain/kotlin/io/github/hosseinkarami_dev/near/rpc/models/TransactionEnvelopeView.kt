package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.TransactionEnvelopeViewSerializer
import kotlin.String
import kotlin.ULong
import kotlin.UShort
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A transaction of either kind, in a chunk, a tx status result or an indexer message.
 */
@Serializable(with = TransactionEnvelopeViewSerializer::class)
public sealed class TransactionEnvelopeView {
  @Serializable
  public data class Signed(
    @SerialName("actions")
    public val actions: List<ActionView>,
    @SerialName("hash")
    public val hash: CryptoHash,
    /**
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("nonce")
    public val nonce: ULong,
    /**
     *  * Minimum: 0.0
     *  * Maximum: 65535.0
     *  * Format: uint16
     *  * Nullable: true
     */
    @SerialName("nonce_index")
    public val nonceIndex: UShort? = null,
    @SerialName("nonce_mode")
    public val nonceMode: NonceMode? = null,
    /**
     *  * Deprecated, retained for backward compatibility.
     *  * Minimum: 0.0
     *  * Format: uint64
     */
    @SerialName("priority_fee")
    public val priorityFee: ULong? = 0.toULong(),
    @SerialName("public_key")
    public val publicKey: PublicKey,
    @SerialName("receiver_id")
    public val receiverId: AccountId,
    @SerialName("signature")
    public val signature: Signature,
    @SerialName("signer_id")
    public val signerId: AccountId,
    /**
     *  * Possible values: signed
     */
    @SerialName("kind")
    public val kind: Kind,
  ) : TransactionEnvelopeView() {
    /**
     *  * Possible values: signed
     */
    @Serializable
    public enum class Kind {
      @SerialName("signed")
      SIGNED,
    }
  }

  @Serializable
  public data class ExternalCall(
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
    /**
     *  * Possible values: external_call
     */
    @SerialName("kind")
    public val kind: Kind,
  ) : TransactionEnvelopeView() {
    /**
     *  * Possible values: external_call
     */
    @Serializable
    public enum class Kind {
      @SerialName("external_call")
      EXTERNAL_CALL,
    }
  }
}
