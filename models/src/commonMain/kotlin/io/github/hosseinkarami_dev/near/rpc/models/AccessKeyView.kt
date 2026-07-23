package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes access key permission scope and nonce.
 */
@Serializable
public data class AccessKeyView(
  /**
   *  * Current nonce; each transaction signed with this key must use a strictly greater value.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("nonce")
  public val nonce: ULong,
  /**
   *  * Access scope: full access, or a function-call permission with an optional allowance and method/receiver limits.
   */
  @SerialName("permission")
  public val permission: AccessKeyPermissionView,
)
