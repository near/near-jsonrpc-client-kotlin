package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.StateProofTargetSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Which piece of a shard's state a light-client state proof targets.
 *
 * An account that runs a global contract has no local code, so `LocalContractCode` is
 * absent for it. `Account::contract()` says which case applies.
 */
@Serializable(with = StateProofTargetSerializer::class)
public sealed class StateProofTarget {
  @Serializable
  public data class Account(
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: account
     */
    @SerialName("target_type")
    public val targetType: TargetType,
  ) : StateProofTarget() {
    /**
     *  * Possible values: account
     */
    @Serializable
    public enum class TargetType {
      @SerialName("account")
      ACCOUNT,
    }
  }

  @Serializable
  public data class LocalContractCode(
    @SerialName("account_id")
    public val accountId: AccountId,
    /**
     *  * Possible values: local_contract_code
     */
    @SerialName("target_type")
    public val targetType: TargetType,
  ) : StateProofTarget() {
    /**
     *  * Possible values: local_contract_code
     */
    @Serializable
    public enum class TargetType {
      @SerialName("local_contract_code")
      LOCAL_CONTRACT_CODE,
    }
  }

  @Serializable
  public data class ContractData(
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("key")
    public val key: StoreKey,
    /**
     *  * Possible values: contract_data
     */
    @SerialName("target_type")
    public val targetType: TargetType,
  ) : StateProofTarget() {
    /**
     *  * Possible values: contract_data
     */
    @Serializable
    public enum class TargetType {
      @SerialName("contract_data")
      CONTRACT_DATA,
    }
  }

  @Serializable
  public data class AccessKey(
    @SerialName("account_id")
    public val accountId: AccountId,
    @SerialName("public_key")
    public val publicKey: PublicKey,
    /**
     *  * Possible values: access_key
     */
    @SerialName("target_type")
    public val targetType: TargetType,
  ) : StateProofTarget() {
    /**
     *  * Possible values: access_key
     */
    @Serializable
    public enum class TargetType {
      @SerialName("access_key")
      ACCESS_KEY,
    }
  }
}
