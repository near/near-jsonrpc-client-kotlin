package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EpochSyncConfig(
  /**
   *  * Number of epochs behind the network head beyond which the node will use
   * epoch sync instead of header sync. Also the maximum age (in epochs) of
   * accepted epoch sync proofs. At the consumption site, this is multiplied
   * by epoch_length to get the horizon in blocks.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_sync_horizon_num_epochs")
  public val epochSyncHorizonNumEpochs: ULong? = 4.toULong(),
  /**
   *  * Timeout for epoch sync requests. The node will continue retrying indefinitely even
   * if this timeout is exceeded.
   */
  @SerialName("timeout_for_epoch_sync")
  public val timeoutForEpochSync: DurationAsStdSchemaProvider? = null,
)
