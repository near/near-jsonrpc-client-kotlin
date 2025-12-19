package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.ErrorWrapperForRpcViewGasKeyErrorSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = ErrorWrapperForRpcViewGasKeyErrorSerializer::class)
public sealed class ErrorWrapperForRpcViewGasKeyError {
  @Serializable
  public data class RequestValidationError(
    @SerialName("cause")
    public val cause: RpcRequestValidationErrorKind,
    /**
     *  * Possible values: REQUEST_VALIDATION_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : ErrorWrapperForRpcViewGasKeyError() {
    /**
     *  * Possible values: REQUEST_VALIDATION_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("REQUEST_VALIDATION_ERROR")
      REQUEST_VALIDATION_ERROR,
    }
  }

  @Serializable
  public data class HandlerError(
    @SerialName("cause")
    public val cause: RpcViewGasKeyError,
    /**
     *  * Possible values: HANDLER_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : ErrorWrapperForRpcViewGasKeyError() {
    /**
     *  * Possible values: HANDLER_ERROR
     */
    @Serializable
    public enum class Name {
      @SerialName("HANDLER_ERROR")
      HANDLER_ERROR,
    }
  }

  @Serializable
  public data class InternalError(
    @SerialName("cause")
    public val cause: io.github.hosseinkarami_dev.near.rpc.models.InternalError,
    /**
     *  * Possible values: INTERNAL_ERROR
     */
    @SerialName("name")
    public val name: Name,
  ) : ErrorWrapperForRpcViewGasKeyError() {
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
