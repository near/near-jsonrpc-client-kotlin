package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Gas key nonces view returned by the `view_gas_key_nonces` RPC query.
 */
@Serializable
public data class GasKeyNoncesView(
  @SerialName("nonces")
  public val nonces: List<ULong>,
)
