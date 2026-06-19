package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.GlobalContractIdentifierSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = GlobalContractIdentifierSerializer::class)
public sealed class GlobalContractIdentifier {
  @Serializable
  public data class Hash(
    @SerialName("hash")
    public val hash: CryptoHash,
  ) : GlobalContractIdentifier()

  @Serializable
  public data class AccountId(
    @SerialName("account_id")
    public val accountId: io.github.hosseinkarami_dev.near.rpc.models.AccountId,
  ) : GlobalContractIdentifier()
}
