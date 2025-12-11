package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * View that preserves JSON format of the runtime config.
 */
@Serializable
public data class RuntimeConfigView(
  /**
   *  * Config that defines rules for account creation.
   */
  @SerialName("account_creation_config")
  public val accountCreationConfig: AccountCreationConfigView? = null,
  /**
   *  * The configuration for congestion control.
   */
  @SerialName("congestion_control_config")
  public val congestionControlConfig: CongestionControlConfigView? = null,
  /**
   *  * Configuration for dynamic resharding feature.
   */
  @SerialName("dynamic_resharding_config")
  public val dynamicReshardingConfig:
      DynamicReshardingConfigView? = DynamicReshardingConfigView(maxNumberOfShards = 999999999999999.toULong(), memoryUsageThreshold = 999999999999999.toULong(), minChildMemoryUsage = 999999999999999.toULong(), minEpochsBetweenResharding = 999999999999999.toULong()),
  /**
   *  * Amount of yN per byte required to have on the account.  See
   * <https://nomicon.io/Economics/Economics.html#state-stake> for details.
   */
  @SerialName("storage_amount_per_byte")
  public val storageAmountPerByte: NearToken? = null,
  /**
   *  * Costs of different actions that need to be performed when sending and
   * processing transaction and receipts.
   */
  @SerialName("transaction_costs")
  public val transactionCosts: RuntimeFeesConfigView? = null,
  /**
   *  * Config of wasm operations.
   */
  @SerialName("wasm_config")
  public val wasmConfig: VMConfigView? = null,
  /**
   *  * Configuration specific to ChunkStateWitness.
   */
  @SerialName("witness_config")
  public val witnessConfig: WitnessConfigView? = null,
)
