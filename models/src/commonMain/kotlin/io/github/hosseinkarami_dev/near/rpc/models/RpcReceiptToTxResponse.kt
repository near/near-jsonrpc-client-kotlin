package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcReceiptToTxResponse(
  @SerialName("sender_account_id")
  public val senderAccountId: AccountId,
  @SerialName("transaction_hash")
  public val transactionHash: CryptoHash,
)
