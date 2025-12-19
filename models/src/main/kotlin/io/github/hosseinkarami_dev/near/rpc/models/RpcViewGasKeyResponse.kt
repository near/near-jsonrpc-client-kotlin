package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UInt
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcViewGasKeyResponse(
  @SerialName("balance")
  public val balance: NearToken,
  @SerialName("block_hash")
  public val blockHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("block_height")
  public val blockHeight: ULong,
  @SerialName("nonces")
  public val nonces: List<ULong>,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("num_nonces")
  public val numNonces: UInt,
  @SerialName("permission")
  public val permission: AccessKeyPermissionView,
)
