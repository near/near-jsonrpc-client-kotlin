package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.PrepareErrorSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Error that can occur while preparing or executing Wasm smart-contract.
 */
@Serializable(with = PrepareErrorSerializer::class)
public sealed class PrepareError {
  /**
   *  * Error happened while serializing the module.
   *  * Possible values: Serialization
   */
  @Serializable
  @SerialName("Serialization")
  public data object Serialization : PrepareError()

  /**
   *  * Error happened while deserializing the module.
   *  * Possible values: Deserialization
   */
  @Serializable
  @SerialName("Deserialization")
  public data object Deserialization : PrepareError()

  /**
   *  * Internal memory declaration has been found in the module.
   *  * Possible values: InternalMemoryDeclared
   */
  @Serializable
  @SerialName("InternalMemoryDeclared")
  public data object InternalMemoryDeclared : PrepareError()

  /**
   *  * Gas instrumentation failed.
   *
   * This most likely indicates the module isn't valid.
   *  * Possible values: GasInstrumentation
   */
  @Serializable
  @SerialName("GasInstrumentation")
  public data object GasInstrumentation : PrepareError()

  /**
   *  * Stack instrumentation failed.
   *
   * This  most likely indicates the module isn't valid.
   *  * Possible values: StackHeightInstrumentation
   */
  @Serializable
  @SerialName("StackHeightInstrumentation")
  public data object StackHeightInstrumentation : PrepareError()

  /**
   *  * Error happened during instantiation.
   *
   * This might indicate that `start` function trapped, or module isn't
   * instantiable and/or un-linkable.
   *  * Possible values: Instantiate
   */
  @Serializable
  @SerialName("Instantiate")
  public data object Instantiate : PrepareError()

  /**
   *  * Error creating memory.
   *  * Possible values: Memory
   */
  @Serializable
  @SerialName("Memory")
  public data object Memory : PrepareError()

  /**
   *  * Contract contains too many functions.
   *  * Possible values: TooManyFunctions
   */
  @Serializable
  @SerialName("TooManyFunctions")
  public data object TooManyFunctions : PrepareError()

  /**
   *  * Contract contains too many locals.
   *  * Possible values: TooManyLocals
   */
  @Serializable
  @SerialName("TooManyLocals")
  public data object TooManyLocals : PrepareError()

  /**
   *  * Contract contains too many tables.
   *  * Possible values: TooManyTables
   */
  @Serializable
  @SerialName("TooManyTables")
  public data object TooManyTables : PrepareError()

  /**
   *  * Contract contains too many table elements.
   *  * Possible values: TooManyTableElements
   */
  @Serializable
  @SerialName("TooManyTableElements")
  public data object TooManyTableElements : PrepareError()

  /**
   *  * A function body in the contract exceeds the size limit.
   *  * Possible values: FunctionBodyTooLarge
   */
  @Serializable
  @SerialName("FunctionBodyTooLarge")
  public data object FunctionBodyTooLarge : PrepareError()

  /**
   *  * The instrumented code exceeds the size limit.
   *  * Possible values: InstrumentedCodeTooLarge
   */
  @Serializable
  @SerialName("InstrumentedCodeTooLarge")
  public data object InstrumentedCodeTooLarge : PrepareError()

  /**
   *  * A function contains too many basic blocks.
   *  * Possible values: TooManyBlocksPerFunction
   */
  @Serializable
  @SerialName("TooManyBlocksPerFunction")
  public data object TooManyBlocksPerFunction : PrepareError()

  /**
   *  * A contract contains too many basic blocks.
   *  * Possible values: TooManyBlocksPerContract
   */
  @Serializable
  @SerialName("TooManyBlocksPerContract")
  public data object TooManyBlocksPerContract : PrepareError()

  /**
   *  * Contract declares too many entries in the wasm type section.
   *  * Possible values: TooManyTypes
   */
  @Serializable
  @SerialName("TooManyTypes")
  public data object TooManyTypes : PrepareError()

  /**
   *  * All contract functions combined have more than `max_params_per_contract` parameters.
   *  * Possible values: TooManyParamsPerFunction
   */
  @Serializable
  @SerialName("TooManyParamsPerFunction")
  public data object TooManyParamsPerFunction : PrepareError()

  /**
   *  * A function has more than `max_params_per_function` parameters.
   *  * Possible values: TooManyParamsPerContract
   */
  @Serializable
  @SerialName("TooManyParamsPerContract")
  public data object TooManyParamsPerContract : PrepareError()
}
