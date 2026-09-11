package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class IndexerExecutionOutcomeWithOptionalReceipt(
  @SerialName("execution_outcome")
  public val executionOutcome: ExecutionOutcomeWithIdView,
  @SerialName("receipt")
  public val receipt: ReceiptView? = null,
)
