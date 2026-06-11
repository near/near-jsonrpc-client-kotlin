package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.UInt
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExecutionMetadataView(
  /**
   *  * One entry per action in the receipt (V4+ only): the contract attached
   * to the receiver account immediately before that action ran. The inner
   * `Option` is `Some` (a tagged contract object) when the account had a
   * contract and `None` (rendered as JSON `null`) when it did not (e.g. an
   * account with no code, or one that did not yet exist). The outer
   * `Option` is `None` for older metadata versions.
   *  * Nullable: true
   */
  @SerialName("contracts")
  public val contracts: List<AccountContractView?>? = null,
  /**
   *  * Nullable: true
   */
  @SerialName("gas_profile")
  public val gasProfile: List<CostGasUsed>? = null,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("version")
  public val version: UInt,
)
