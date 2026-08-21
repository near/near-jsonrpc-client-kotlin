package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcLightClientExecutionOutcomeProofRequestSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcLightClientExecutionOutcomeProofRequestSerializer::class)
public sealed class RpcLightClientExecutionOutcomeProofRequest {
  @Serializable
  public data class Transaction(
    @SerialName("sender_id")
    public val senderId: AccountId,
    @SerialName("transaction_hash")
    public val transactionHash: CryptoHash,
    /**
     *  * Possible values: transaction
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("light_client_head")
    public val lightClientHead: CryptoHash,
  ) : RpcLightClientExecutionOutcomeProofRequest() {
    /**
     *  * Possible values: transaction
     */
    @Serializable
    public enum class Type {
      @SerialName("transaction")
      TRANSACTION,
    }
  }

  @Serializable
  public data class Receipt(
    @SerialName("receipt_id")
    public val receiptId: CryptoHash,
    @SerialName("receiver_id")
    public val receiverId: AccountId,
    /**
     *  * Possible values: receipt
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("light_client_head")
    public val lightClientHead: CryptoHash,
  ) : RpcLightClientExecutionOutcomeProofRequest() {
    /**
     *  * Possible values: receipt
     */
    @Serializable
    public enum class Type {
      @SerialName("receipt")
      RECEIPT,
    }
  }
}
