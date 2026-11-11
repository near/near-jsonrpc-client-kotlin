package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ExternalCallChunkLimitSerializer
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A share of a chunk's limits that its external calls used up, with what the chunk's earlier
 * external calls used and the share.
 */
@Serializable(with = ExternalCallChunkLimitSerializer::class)
public sealed class ExternalCallChunkLimit {
  /**
   *  * The compute used by the chunk's earlier external calls reached their share of the chunk's
   * compute limit.
   */
  @Serializable
  public data class Compute(
    @SerialName("Compute")
    public val compute: ComputePayload,
  ) : ExternalCallChunkLimit() {
    @Serializable
    public data class ComputePayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("used")
      public val used: ULong,
    )
  }

  /**
   *  * The storage proof recorded by the chunk's earlier external calls reached their share of
   * the chunk's storage proof limit.
   */
  @Serializable
  public data class StorageProof(
    @SerialName("StorageProof")
    public val storageProof: StorageProofPayload,
  ) : ExternalCallChunkLimit() {
    @Serializable
    public data class StorageProofPayload(
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("limit")
      public val limit: ULong,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("used")
      public val used: ULong,
    )
  }
}
