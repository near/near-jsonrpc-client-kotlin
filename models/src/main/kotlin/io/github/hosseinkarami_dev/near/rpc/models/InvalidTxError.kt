package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.InvalidTxErrorSerializer
import kotlin.Double
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * An error happened during TX execution
 */
@Serializable(with = InvalidTxErrorSerializer::class)
public sealed class InvalidTxError {
  /**
   *  * Happens if a wrong AccessKey used or AccessKey has not enough permissions
   */
  @Serializable
  public data class InvalidAccessKeyError(
    @SerialName("InvalidAccessKeyError")
    public val invalidAccessKeyError:
        io.github.hosseinkarami_dev.near.rpc.models.InvalidAccessKeyError,
  ) : InvalidTxError()

  /**
   *  * TX signer_id is not a valid [`AccountId`]
   */
  @Serializable
  public data class InvalidSignerId(
    @SerialName("InvalidSignerId")
    public val invalidSignerId: InvalidSignerIdPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidSignerIdPayload(
      @SerialName("signer_id")
      public val signerId: String,
    )
  }

  /**
   *  * TX signer_id is not found in a storage
   */
  @Serializable
  public data class SignerDoesNotExist(
    @SerialName("SignerDoesNotExist")
    public val signerDoesNotExist: SignerDoesNotExistPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class SignerDoesNotExistPayload(
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  /**
   *  * Transaction nonce must be strictly greater than `account[access_key].nonce`.
   */
  @Serializable
  public data class InvalidNonce(
    @SerialName("InvalidNonce")
    public val invalidNonce: InvalidNoncePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidNoncePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("ak_nonce")
      public val akNonce: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("tx_nonce")
      public val txNonce: ULong,
    )
  }

  /**
   *  * Transaction nonce is larger than the upper bound given by the block height
   */
  @Serializable
  public data class NonceTooLarge(
    @SerialName("NonceTooLarge")
    public val nonceTooLarge: NonceTooLargePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class NonceTooLargePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("tx_nonce")
      public val txNonce: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("upper_bound")
      public val upperBound: ULong,
    )
  }

  /**
   *  * TX receiver_id is not a valid AccountId
   */
  @Serializable
  public data class InvalidReceiverId(
    @SerialName("InvalidReceiverId")
    public val invalidReceiverId: InvalidReceiverIdPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidReceiverIdPayload(
      @SerialName("receiver_id")
      public val receiverId: String,
    )
  }

  /**
   *  * TX signature is not valid
   *  * Possible values: InvalidSignature
   */
  @Serializable
  @SerialName("InvalidSignature")
  public data object InvalidSignature : InvalidTxError()

  /**
   *  * Account does not have enough balance to cover TX cost
   */
  @Serializable
  public data class NotEnoughBalance(
    @SerialName("NotEnoughBalance")
    public val notEnoughBalance: NotEnoughBalancePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class NotEnoughBalancePayload(
      @SerialName("balance")
      public val balance: NearToken,
      @SerialName("cost")
      public val cost: NearToken,
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  /**
   *  * Signer account doesn't have enough balance after transaction.
   */
  @Serializable
  public data class LackBalanceForState(
    @SerialName("LackBalanceForState")
    public val lackBalanceForState: LackBalanceForStatePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class LackBalanceForStatePayload(
      /**
       *  * Required balance to cover the state.
       */
      @SerialName("amount")
      public val amount: NearToken,
      /**
       *  * An account which doesn't have enough balance to cover storage.
       */
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  /**
   *  * An integer overflow occurred during transaction cost estimation.
   *  * Possible values: CostOverflow
   */
  @Serializable
  @SerialName("CostOverflow")
  public data object CostOverflow : InvalidTxError()

  /**
   *  * Transaction parent block hash doesn't belong to the current chain
   *  * Possible values: InvalidChain
   */
  @Serializable
  @SerialName("InvalidChain")
  public data object InvalidChain : InvalidTxError()

  /**
   *  * Transaction has expired
   *  * Possible values: Expired
   */
  @Serializable
  @SerialName("Expired")
  public data object Expired : InvalidTxError()

  /**
   *  * An error occurred while validating actions of a Transaction.
   */
  @Serializable
  public data class ActionsValidation(
    @SerialName("ActionsValidation")
    public val actionsValidation: ActionsValidationError,
  ) : InvalidTxError()

  /**
   *  * The size of serialized transaction exceeded the limit.
   */
  @Serializable
  public data class TransactionSizeExceeded(
    @SerialName("TransactionSizeExceeded")
    public val transactionSizeExceeded: TransactionSizeExceededPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class TransactionSizeExceededPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("size")
      public val size: ULong,
    )
  }

  /**
   *  * Transaction version is invalid.
   *  * Possible values: InvalidTransactionVersion
   */
  @Serializable
  @SerialName("InvalidTransactionVersion")
  public data object InvalidTransactionVersion : InvalidTxError()

  @Serializable
  public data class StorageError(
    @SerialName("StorageError")
    public val storageError: io.github.hosseinkarami_dev.near.rpc.models.StorageError,
  ) : InvalidTxError()

  /**
   *  * The receiver shard of the transaction is too congested to accept new
   * transactions at the moment.
   */
  @Serializable
  public data class ShardCongested(
    @SerialName("ShardCongested")
    public val shardCongested: ShardCongestedPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class ShardCongestedPayload(
      /**
       *  * A value between 0 (no congestion) and 1 (max congestion).
       *  * Format: double
       */
      @SerialName("congestion_level")
      public val congestionLevel: Double,
      /**
       *  * The congested shard.
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("shard_id")
      public val shardId: UInt,
    )
  }

  /**
   *  * The receiver shard of the transaction missed several chunks and rejects
   * new transaction until it can make progress again.
   */
  @Serializable
  public data class ShardStuck(
    @SerialName("ShardStuck")
    public val shardStuck: ShardStuckPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class ShardStuckPayload(
      /**
       *  * The number of blocks since the last included chunk of the shard.
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("missed_chunks")
      public val missedChunks: ULong,
      /**
       *  * The shard that fails making progress.
       *  * Minimum: 0.0
       *  * Format: uint32
       */
      @SerialName("shard_id")
      public val shardId: UInt,
    )
  }

  /**
   *  * Transaction is specifying an invalid nonce index. Gas key transactions
   * must have a nonce_index in valid range, regular transactions must not.
   */
  @Serializable
  public data class InvalidNonceIndex(
    @SerialName("InvalidNonceIndex")
    public val invalidNonceIndex: InvalidNonceIndexPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class InvalidNonceIndexPayload(
      /**
       *  * Number of nonces supported by the key. 0 means no nonce_index allowed (regular key).
       *  * Minimum: 0.0
       *  * Maximum: 65535.0
       *  * Format: uint16
       */
      @SerialName("num_nonces")
      public val numNonces: UShort,
      /**
       *  * The nonce_index from the transaction (None if missing).
       *  * Minimum: 0.0
       *  * Maximum: 65535.0
       *  * Format: uint16
       *  * Nullable: true
       */
      @SerialName("tx_nonce_index")
      public val txNonceIndex: UShort? = null,
    )
  }

  /**
   *  * Gas key does not have enough balance to cover gas costs.
   */
  @Serializable
  public data class NotEnoughGasKeyBalance(
    @SerialName("NotEnoughGasKeyBalance")
    public val notEnoughGasKeyBalance: NotEnoughGasKeyBalancePayload,
  ) : InvalidTxError() {
    @Serializable
    public data class NotEnoughGasKeyBalancePayload(
      @SerialName("balance")
      public val balance: NearToken,
      @SerialName("cost")
      public val cost: NearToken,
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }

  /**
   *  * Gas key transaction failed because the account could not cover the deposit cost.
   * Gas is still charged from the gas key in this case.
   */
  @Serializable
  public data class NotEnoughBalanceForDeposit(
    @SerialName("NotEnoughBalanceForDeposit")
    public val notEnoughBalanceForDeposit: NotEnoughBalanceForDepositPayload,
  ) : InvalidTxError() {
    @Serializable
    public data class NotEnoughBalanceForDepositPayload(
      @SerialName("balance")
      public val balance: NearToken,
      @SerialName("cost")
      public val cost: NearToken,
      @SerialName("reason")
      public val reason: DepositCostFailureReason,
      @SerialName("signer_id")
      public val signerId: AccountId,
    )
  }
}
