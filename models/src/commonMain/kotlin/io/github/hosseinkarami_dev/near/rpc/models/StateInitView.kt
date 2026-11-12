package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.StateInitViewSerializer
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * The initial state of a `0s` or `0u` account, as its state-init action carries it.
 */
@Serializable(with = StateInitViewSerializer::class)
public sealed class StateInitView {
  @Serializable
  public data class Deterministic(
    @SerialName("deterministic")
    public val deterministic: DeterministicPayload,
  ) : StateInitView() {
    @Serializable
    public data class DeterministicPayload(
      @SerialName("code")
      public val code: GlobalContractIdentifierView,
      @SerialName("data")
      public val `data`: Map<String, String>,
    )
  }

  @Serializable
  public data class Universal(
    @SerialName("universal")
    public val universal: RawStateInit,
  ) : StateInitView()
}
