package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Lists access keys
 */
@Serializable
public data class AccessKeyList(
  @SerialName("keys")
  public val keys: List<AccessKeyInfoView>,
  /**
   *  * Pagination cursor. When `Some`, the listing was truncated and the caller
   * should issue another request with `after_key` set to this handle to fetch
   * the next page. `None` means this was the last page.
   */
  @SerialName("last_key")
  public val lastKey: PublicKeyHandle? = null,
)
