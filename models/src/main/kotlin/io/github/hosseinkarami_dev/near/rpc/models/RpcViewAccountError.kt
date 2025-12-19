package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcViewAccountErrorSerializer
import kotlin.String
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = RpcViewAccountErrorSerializer::class)
public sealed class RpcViewAccountError {
  @Serializable
  public data class UnknownBlock(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_BLOCK
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcViewAccountError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_reference")
      public val blockReference: BlockReference,
    )

    /**
     *  * Possible values: UNKNOWN_BLOCK
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_BLOCK")
      UNKNOWN_BLOCK,
    }
  }

  @Serializable
  public data class InvalidAccount(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: INVALID_ACCOUNT
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcViewAccountError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("requested_account_id")
      public val requestedAccountId: AccountId,
    )

    /**
     *  * Possible values: INVALID_ACCOUNT
     */
    @Serializable
    public enum class Name {
      @SerialName("INVALID_ACCOUNT")
      INVALID_ACCOUNT,
    }
  }

  @Serializable
  public data class UnknownAccount(
    @SerialName("info")
    public val info: InfoPayload,
    /**
     *  * Possible values: UNKNOWN_ACCOUNT
     */
    @SerialName("name")
    public val name: Name,
  ) : RpcViewAccountError() {
    @Serializable
    public data class InfoPayload(
      @SerialName("block_hash")
      public val blockHash: CryptoHash,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("block_height")
      public val blockHeight: ULong,
      @SerialName("requested_account_id")
      public val requestedAccountId: AccountId,
    )

    /**
     *  * Possible values: UNKNOWN_ACCOUNT
     */
    @Serializable
    public enum class Name {
      @SerialName("UNKNOWN_ACCOUNT")
      UNKNOWN_ACCOUNT,
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
  ) : RpcViewAccountError() {
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
