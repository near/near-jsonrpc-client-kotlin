package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class IndexerTransactionWithOutcome(
  @SerialName("outcome")
  public val outcome: IndexerExecutionOutcomeWithOptionalReceipt,
  @SerialName("transaction")
  public val transaction: SignedTransactionView,
)
