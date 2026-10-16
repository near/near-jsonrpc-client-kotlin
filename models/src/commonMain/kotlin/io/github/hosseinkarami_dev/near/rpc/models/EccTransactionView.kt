package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EccTransactionView(
  @SerialName("contract_id")
  public val contractId: AccountId,
  @SerialName("hash")
  public val hash: CryptoHash,
  @SerialName("payload")
  public val payload: String,
)
