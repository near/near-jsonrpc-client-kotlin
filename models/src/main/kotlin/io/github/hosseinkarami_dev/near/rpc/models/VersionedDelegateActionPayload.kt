package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class VersionedDelegateActionPayload(
  @SerialName("V2")
  public val v2: DelegateActionV2,
)
