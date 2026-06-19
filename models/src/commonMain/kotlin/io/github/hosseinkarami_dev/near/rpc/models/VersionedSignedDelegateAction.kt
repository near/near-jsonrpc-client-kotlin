package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class VersionedSignedDelegateAction(
  @SerialName("delegate_action")
  public val delegateAction: VersionedDelegateActionPayload,
  @SerialName("signature")
  public val signature: Signature,
)
