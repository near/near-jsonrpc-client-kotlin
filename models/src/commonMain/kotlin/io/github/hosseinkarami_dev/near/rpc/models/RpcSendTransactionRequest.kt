package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * On the wire, a signed transaction goes in `signed_tx_base64` and an ECC in
 * `external_call_base64`, so requests with a signed transaction look as they did before ECCs.
 */
@Serializable
public data class RpcSendTransactionRequest(
  /**
   *  * An external contract call (ECC). Exactly one of this and `signed_tx_base64` is expected.
   */
  @SerialName("external_call_base64")
  public val externalCallBase64: EccTransaction? = null,
  /**
   *  * A signed transaction. Exactly one of this and `external_call_base64` is expected.
   */
  @SerialName("signed_tx_base64")
  public val signedTxBase64: SignedTransaction? = null,
  @SerialName("wait_until")
  public val waitUntil: TxExecutionStatus? = TxExecutionStatus.ExecutedOptimistic,
)
