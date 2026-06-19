package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UInt
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Per-validator chunk endorsement stats accumulated over a spice epoch,
 * indexed by the current epoch's validator id. Carried on the last block of
 * the epoch (see `BlockHeaderInnerRestV7`) and consumed by reward and kickout.
 */
@Serializable
public data class SpiceChunkEndorsementStats(
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("expected")
  public val expected: UInt,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("produced")
  public val produced: UInt,
)
