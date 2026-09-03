package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.StateChangeWithCauseViewSerializer
import kotlin.String
import kotlin.ULong
import kotlin.UShort
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = StateChangeWithCauseViewSerializer::class)
public sealed class StateChangeWithCauseView {
  @Serializable
  public data class AccountUpdate(
    /**
     *  * A view of the account
     */
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: account_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    /**
     *  * A view of the account
     */
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      /**
       *  * Liquid (non-staked) account balance, in yoctoNEAR.
       */
      @SerialName("amount")
      public val amount: NearToken,
      /**
       *  * The nonce an uninitialized account's own transactions must use, present
       * only while it is uninitialized. A self-signed state init is the one
       * transaction such an account can send, and this is the only way for a
       * client to learn the nonce it must carry: there is no access key to query.
       *  * Minimum: 0.0
       *  * Format: uint64
       *  * Nullable: true
       */
      @SerialName("bootstrap_nonce")
      public val bootstrapNonce: ULong? = null,
      /**
       *  * Hash of the deployed contract code; the all-`1`s hash when no contract is deployed.
       */
      @SerialName("code_hash")
      public val codeHash: CryptoHash,
      /**
       *  * Set when the account uses a global contract referenced by the deploying account id.
       */
      @SerialName("global_contract_account_id")
      public val globalContractAccountId: AccountId? = null,
      /**
       *  * Set when the account uses a global contract referenced by code hash.
       */
      @SerialName("global_contract_hash")
      public val globalContractHash: CryptoHash? = null,
      /**
       *  * Staked balance locked for validation, in yoctoNEAR.
       */
      @SerialName("locked")
      public val locked: NearToken,
      /**
       *  * Whether the account is initialized. Only a universal account can be
       * uninitialized: it has no access keys, code or data until a
       * `UniversalStateInit` arrives. Omitted for initialized accounts.
       */
      @SerialName("state")
      public val state: AccountState? = null,
      /**
       *  * Deprecated and unused. TODO(2271): remove.
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("storage_paid_at")
      public val storagePaidAt: ULong? = 0.toULong(),
      /**
       *  * Total storage used by the account, in bytes.
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("storage_usage")
      public val storageUsage: ULong,
    )

    /**
     *  * Possible values: account_update
     */
    @Serializable
    public enum class Type {
      @SerialName("account_update")
      ACCOUNT_UPDATE,
    }
  }

  @Serializable
  public data class AccountDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: account_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )

    /**
     *  * Possible values: account_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("account_deletion")
      ACCOUNT_DELETION,
    }
  }

  @Serializable
  public data class AccessKeyUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: access_key_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("access_key")
      public val accessKey: AccessKeyView,
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKeyHandle,
    )

    /**
     *  * Possible values: access_key_update
     */
    @Serializable
    public enum class Type {
      @SerialName("access_key_update")
      ACCESS_KEY_UPDATE,
    }
  }

  @Serializable
  public data class AccessKeyDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: access_key_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("public_key")
      public val publicKey: PublicKeyHandle,
    )

    /**
     *  * Possible values: access_key_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("access_key_deletion")
      ACCESS_KEY_DELETION,
    }
  }

  @Serializable
  public data class GasKeyNonceUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: gas_key_nonce_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      /**
       *  * Minimum: 0.0
       *  * Maximum: 65535.0
       *  * Format: uint16
       */
      @SerialName("index")
      public val index: UShort,
      /**
       *  * Minimum: 0.0
       *  * Format: uint64
       */
      @SerialName("nonce")
      public val nonce: ULong,
      @SerialName("public_key")
      public val publicKey: PublicKeyHandle,
    )

    /**
     *  * Possible values: gas_key_nonce_update
     */
    @Serializable
    public enum class Type {
      @SerialName("gas_key_nonce_update")
      GAS_KEY_NONCE_UPDATE,
    }
  }

  @Serializable
  public data class DataUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: data_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("key_base64")
      public val keyBase64: StoreKey,
      @SerialName("value_base64")
      public val valueBase64: StoreValue,
    )

    /**
     *  * Possible values: data_update
     */
    @Serializable
    public enum class Type {
      @SerialName("data_update")
      DATA_UPDATE,
    }
  }

  @Serializable
  public data class DataDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: data_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("key_base64")
      public val keyBase64: StoreKey,
    )

    /**
     *  * Possible values: data_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("data_deletion")
      DATA_DELETION,
    }
  }

  @Serializable
  public data class ContractCodeUpdate(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: contract_code_update
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
      @SerialName("code_base64")
      public val codeBase64: String,
    )

    /**
     *  * Possible values: contract_code_update
     */
    @Serializable
    public enum class Type {
      @SerialName("contract_code_update")
      CONTRACT_CODE_UPDATE,
    }
  }

  @Serializable
  public data class ContractCodeDeletion(
    @SerialName("change")
    public val change: ChangePayload,
    /**
     *  * Possible values: contract_code_deletion
     */
    @SerialName("type")
    public val type: Type,
    @SerialName("cause")
    public val cause: StateChangeCauseView,
  ) : StateChangeWithCauseView() {
    @Serializable
    public data class ChangePayload(
      @SerialName("account_id")
      public val accountId: AccountId,
    )

    /**
     *  * Possible values: contract_code_deletion
     */
    @Serializable
    public enum class Type {
      @SerialName("contract_code_deletion")
      CONTRACT_CODE_DELETION,
    }
  }
}
