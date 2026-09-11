package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class JsonRpcRequestForExperimentalIndexerBlock(
  @SerialName("id")
  public val id: String,
  @SerialName("jsonrpc")
  public val jsonrpc: String,
  /**
   *  * Possible values: EXPERIMENTAL_indexer_block
   */
  @SerialName("method")
  public val method: Method,
  @SerialName("params")
  public val params: RpcIndexerBlockRequest,
) {
  /**
   *  * Possible values: EXPERIMENTAL_indexer_block
   */
  @Serializable
  public enum class Method {
    @SerialName("EXPERIMENTAL_indexer_block")
    EXPERIMENTAL_INDEXER_BLOCK,
  }
}
