package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.TimeoutErrorCauseSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Explains why a transaction status request returned a `RpcTransactionError::TimeoutError`:
 */
@Serializable(with = TimeoutErrorCauseSerializer::class)
public sealed class TimeoutErrorCause {
  /**
   *  * The node never observed the transaction on chain.
   */
  @Serializable
  public data class NotObserved(
    /**
     *  * Possible values: NOT_OBSERVED
     */
    @SerialName("cause")
    public val cause: Cause,
  ) : TimeoutErrorCause() {
    /**
     *  * Possible values: NOT_OBSERVED
     */
    @Serializable
    public enum class Cause {
      @SerialName("NOT_OBSERVED")
      NOT_OBSERVED,
    }
  }

  /**
   *  * The transaction was observed but is still pending the requested finality. The
   * last-known status is included so the caller can re-poll for a higher finality.
   */
  @Serializable
  public data class Pending(
    /**
     *  * Possible values: PENDING
     */
    @SerialName("cause")
    public val cause: Cause,
    @SerialName("status")
    public val status: RpcTransactionResponse,
  ) : TimeoutErrorCause() {
    /**
     *  * Possible values: PENDING
     */
    @Serializable
    public enum class Cause {
      @SerialName("PENDING")
      PENDING,
    }
  }

  /**
   *  * The node does not track the transaction's shard and could not get an answer from a
   * chunk producer that does before the timeout.
   */
  @Serializable
  public data class DoesNotTrackShard(
    /**
     *  * Possible values: DOES_NOT_TRACK_SHARD
     */
    @SerialName("cause")
    public val cause: Cause,
    @SerialName("shard_id")
    public val shardId: ShardId,
  ) : TimeoutErrorCause() {
    /**
     *  * Possible values: DOES_NOT_TRACK_SHARD
     */
    @Serializable
    public enum class Cause {
      @SerialName("DOES_NOT_TRACK_SHARD")
      DOES_NOT_TRACK_SHARD,
    }
  }

  /**
   *  * The node could not produce a usable transaction status before the timeout (for
   * example a repeated internal error, or no response at all).
   */
  @Serializable
  public data class Error(
    /**
     *  * Possible values: ERROR
     */
    @SerialName("cause")
    public val cause: Cause,
    @SerialName("debug_info")
    public val debugInfo: String,
  ) : TimeoutErrorCause() {
    /**
     *  * Possible values: ERROR
     */
    @Serializable
    public enum class Cause {
      @SerialName("ERROR")
      ERROR,
    }
  }
}
