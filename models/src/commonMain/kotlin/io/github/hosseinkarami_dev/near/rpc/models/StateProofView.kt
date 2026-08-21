package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A value read from a shard's state, with the trie nodes that prove it against the
 * chunk's `state_root`. An absent `value` is proved the same way.
 */
@Serializable
public data class StateProofView(
  @SerialName("nodes")
  public val nodes: List<String>,
  @SerialName("value")
  public val `value`: StoreValue? = null,
)
