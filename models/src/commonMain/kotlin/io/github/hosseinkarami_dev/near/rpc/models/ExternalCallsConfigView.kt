package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Limits on external contract calls, per call and per chunk.
 */
@Serializable
public data class ExternalCallsConfigView(
  /**
   *  * The share of the chunk's compute limit that its external calls may use.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("chunk_compute_share")
  public val chunkComputeShare: List<Int>,
  /**
   *  * The share of `main_storage_proof_size_soft_limit` that a chunk's external calls may
   * record.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("chunk_storage_proof_share")
  public val chunkStorageProofShare: List<Int>,
  /**
   *  * The share of `combined_transactions_size_limit` that a chunk's external calls may take.
   *  * Min Items: 2
   *  * Max Items: 2
   */
  @SerialName("chunk_transactions_size_share")
  public val chunkTransactionsSizeShare: List<Int>,
  /**
   *  * Max storage proof an external call's run may record, in bytes.
   *  * Minimum: 0.0
   *  * Format: uint
   */
  @SerialName("max_call_recorded_size")
  public val maxCallRecordedSize: UInt,
  /**
   *  * Max size of an external contract call, in bytes.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_call_size")
  public val maxCallSize: ULong,
  /**
   *  * Max number of external calls in a chunk.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("max_calls_per_chunk")
  public val maxCallsPerChunk: ULong,
) {
  init {
    require((chunkComputeShare?.size ?: 0) >= 2) { "ExternalCallsConfigView.chunkComputeShare must contain at least 2 items (minItems = 2)" }}
  init {
    require((chunkComputeShare?.size ?: 0) <= 2) { "ExternalCallsConfigView.chunkComputeShare must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((chunkStorageProofShare?.size ?: 0) >= 2) { "ExternalCallsConfigView.chunkStorageProofShare must contain at least 2 items (minItems = 2)" }}
  init {
    require((chunkStorageProofShare?.size ?: 0) <= 2) { "ExternalCallsConfigView.chunkStorageProofShare must contain no more than 2 items (maxItems = 2)" }}
  init {
    require((chunkTransactionsSizeShare?.size ?: 0) >= 2) { "ExternalCallsConfigView.chunkTransactionsSizeShare must contain at least 2 items (minItems = 2)" }}
  init {
    require((chunkTransactionsSizeShare?.size ?: 0) <= 2) { "ExternalCallsConfigView.chunkTransactionsSizeShare must contain no more than 2 items (maxItems = 2)" }}
}
