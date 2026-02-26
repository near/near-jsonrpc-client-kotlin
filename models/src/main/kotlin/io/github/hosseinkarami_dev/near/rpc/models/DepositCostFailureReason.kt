package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Reason why a gas key transaction failed at the deposit/account level.
 * In these cases, gas is still charged from the gas key.
 *  * Possible values: NotEnoughBalance, LackBalanceForState
 */
@Serializable
public enum class DepositCostFailureReason {
  @SerialName("NotEnoughBalance")
  NOT_ENOUGH_BALANCE,
  @SerialName("LackBalanceForState")
  LACK_BALANCE_FOR_STATE,
}
