package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcIndexerBlockErrorSerializer
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcIndexerBlockErrorSerializer::class)
public sealed class RpcIndexerBlockError {
  @Serializable
  public data class DataUnavailable(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: DATA_UNAVAILABLE
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcIndexerBlockError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: DATA_UNAVAILABLE
     */
    @Serializable
    public enum class Name {
      @SerialName("DATA_UNAVAILABLE")
      DATA_UNAVAILABLE,
    }
  }

  @Serializable
  public data class IncompleteData(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INCOMPLETE_DATA
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcIndexerBlockError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: INCOMPLETE_DATA
     */
    @Serializable
    public enum class Name {
      @SerialName("INCOMPLETE_DATA")
      INCOMPLETE_DATA,
    }
  }

  @Serializable
  public data class Unsupported(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNSUPPORTED
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcIndexerBlockError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: UNSUPPORTED
     */
    @Serializable
    public enum class Name {
      @SerialName("UNSUPPORTED")
      UNSUPPORTED,
    }
  }

  @Serializable
  public data class LimitExceeded(
    /**
     *  * Possible values: LIMIT_EXCEEDED
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcIndexerBlockError() {
    /**
     *  * Possible values: LIMIT_EXCEEDED
     */
    @Serializable
    public enum class Name {
      @SerialName("LIMIT_EXCEEDED")
      LIMIT_EXCEEDED,
    }
  }

  @Serializable
  public data class Busy(
    /**
     *  * Possible values: BUSY
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcIndexerBlockError() {
    /**
     *  * Possible values: BUSY
     */
    @Serializable
    public enum class Name {
      @SerialName("BUSY")
      BUSY,
    }
  }

  @Serializable
  public data class InternalError(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcIndexerBlockError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("error_message")
      public val errorMessage: String,
    )

    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("INTERNAL_ERROR")
      INTERNAL_ERROR,
    }
  }
}
