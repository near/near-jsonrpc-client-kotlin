package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.AuthorizationContextSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * What authorized a chain of receipts: an access key that signed a transaction, or an
 * external call its contract accepted.
 */
@Serializable(with = AuthorizationContextSerializer::class)
public sealed class AuthorizationContext {
  /**
   *  * Possible values: ExternalContractCall
   */
  @Serializable
  @SerialName("ExternalContractCall")
  public data object ExternalContractCall : AuthorizationContext()

  @Serializable
  public data class AccessKey(
    @SerialName("AccessKey")
    public val accessKey: PublicKey,
  ) : AuthorizationContext()
}
