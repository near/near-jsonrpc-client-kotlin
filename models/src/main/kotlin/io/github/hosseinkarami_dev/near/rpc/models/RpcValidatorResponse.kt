package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.ULong
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Information about this epoch validators and next epoch validators
 */
@Serializable
public data class RpcValidatorResponse(
  /**
   *  * Fishermen for the current epoch
   */
  @SerialName("current_fishermen")
  public val currentFishermen: List<ValidatorStakeView>,
  /**
   *  * Proposals in the current epoch
   */
  @SerialName("current_proposals")
  public val currentProposals: List<ValidatorStakeView>,
  /**
   *  * Validators for the current epoch
   */
  @SerialName("current_validators")
  public val currentValidators: List<CurrentEpochValidatorInfo>,
  /**
   *  * Epoch height
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_height")
  public val epochHeight: ULong,
  /**
   *  * Epoch start block height
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("epoch_start_height")
  public val epochStartHeight: ULong,
  /**
   *  * Fishermen for the next epoch
   */
  @SerialName("next_fishermen")
  public val nextFishermen: List<ValidatorStakeView>,
  /**
   *  * Validators for the next epoch
   */
  @SerialName("next_validators")
  public val nextValidators: List<NextEpochValidatorInfo>,
  /**
   *  * Kickout in the previous epoch
   */
  @SerialName("prev_epoch_kickout")
  public val prevEpochKickout: List<ValidatorKickoutView>,
  /**
   *  * Per-validator rewards paid out at the start of the previous epoch.
   * For epoch E, this contains the rewards earned in epoch E-2 that were
   * added to validator and treasury balances at the first block of epoch
   * E-1 (via `ValidatorAccountsUpdate`).
   */
  @SerialName("validator_reward_paid_prev_epoch")
  public val validatorRewardPaidPrevEpoch: Map<String, NearToken>? = mapOf(),
)
