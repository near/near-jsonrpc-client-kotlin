package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.TransactionEnvelopeViewSerializer
import kotlinx.serialization.Serializable

/**
 *  * A transaction in a chunk. Untagged so that a signed transaction keeps the JSON shape it
 * always had.
 */
@Serializable(with = TransactionEnvelopeViewSerializer::class)
public sealed class TransactionEnvelopeView {
  @Serializable
  public data class SignedTransactionView(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.SignedTransactionView,
  ) : TransactionEnvelopeView()

  @Serializable
  public data class EccTransactionView(
    public val `value`: io.github.hosseinkarami_dev.near.rpc.models.EccTransactionView,
  ) : TransactionEnvelopeView()
}
