package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configures how to fetch state parts during state sync.
 */
@Serializable
public enum class SyncConfig {
  @SerialName("Peers")
  PEERS,
}
