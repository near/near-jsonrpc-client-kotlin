package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EpochSyncConfig(
  /**
   *  * This serves as two purposes: (1) the node will not epoch sync and instead resort to
   * header sync, if the genesis block is within this many blocks from the current block;
   * (2) the node will reject an epoch sync proof if the provided proof is for an epoch
   * that is more than this many blocks behind the current block.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_sync_horizon")
  public val epochSyncHorizon: ULong? = null,
  /**
   *  * Timeout for epoch sync requests. The node will continue retrying indefinitely even
   * if this timeout is exceeded.
   */
  @SerialName("timeout_for_epoch_sync")
  public val timeoutForEpochSync: DurationAsStdSchemaProvider? = null,
)
