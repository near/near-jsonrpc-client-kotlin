package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalReceiptToTx(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_receipt_to_tx
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcReceiptToTxRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_receipt_to_tx
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_receipt_to_tx")
    EXPERIMENTAL_RECEIPT_TO_TX,
  }
}
