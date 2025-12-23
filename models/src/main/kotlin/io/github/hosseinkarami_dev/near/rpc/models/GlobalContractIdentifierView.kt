package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.GlobalContractIdentifierViewSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = GlobalContractIdentifierViewSerializer::class)
public sealed class GlobalContractIdentifierView {
  @Serializable
  public data class Hash(
    @SerialName("hash")
    public val hash: CryptoHash,
  ) : GlobalContractIdentifierView()

  @Serializable
  public data class AccountId(
    @SerialName("account_id")
    public val accountId: io.github.hosseinkarami_dev.near.rpc.models.AccountId,
  ) : GlobalContractIdentifierView()
}
