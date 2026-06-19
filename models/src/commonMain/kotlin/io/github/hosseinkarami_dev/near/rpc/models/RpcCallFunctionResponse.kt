package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.UByte
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * A result returned by contract method
 */
@Serializable
public data class RpcCallFunctionResponse(
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_height")
  public val blockHeight: ULong,
  @SerialName("logs")
  public val logs: List<String>,
  @SerialName("result")
  public val result: List<UByte>,
)
