package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * View that preserves JSON format of the runtime config.
 */
@Serializable
public data class RuntimeConfigView(
  /**
   *  * How much creating an account should cost in NEAR. Taken into account when burning gas for
   * account creation.
   */
  @SerialName("account_creation_charge")
  public val accountCreationCharge: NearToken? = NearToken("0"),
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
   *  * Minimum price at which the gas attached to a receipt is purchased. The price at which it is
   * burned might be lower, in which case the difference is refunded after execution.
   */
  @SerialName("min_gas_purchase_price")
  public val minGasPurchasePrice: NearToken? = NearToken("0"),
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
