package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Configuration for a cloud-based archival writer. If this config is present, the writer is enabled and
 * writes chunk-related data based on the tracked shards. This config also controls additional archival
 * behavior such as block data and polling interval.
 */
@Serializable
public data class CloudArchivalWriterConfig(
  /**
   *  * Determines whether block-related data should be written to cloud storage.
   */
  @SerialName("archive_block_data")
  public val archiveBlockData: Boolean? = false,
  /**
   *  * Interval at which the system checks for new blocks or chunks to archive.
   */
  @SerialName("polling_interval")
  public val pollingInterval:
      DurationAsStdSchemaProvider? = DurationAsStdSchemaProvider(nanos = 0.toInt(), secs = 1L),
  /**
   *  * Cadence of state snapshots, in epochs. Higher values reduce bucket cost at
   * the expense of potentially longer delta replay during reader bootstrap.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("snapshot_every_n_epochs")
  public val snapshotEveryNEpochs: ULong? = 10.toULong(),
)
