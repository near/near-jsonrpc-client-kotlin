package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A view of the contract code.
 */
@Serializable
public data class RpcViewCodeResponse(
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_height")
  public val blockHeight: ULong,
  @SerialName("code_base64")
  public val codeBase64: String,
  @SerialName("hash")
  public val hash: CryptoHash,
)
