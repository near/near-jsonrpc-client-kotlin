package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.ULong
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class RpcReceiptToTxRequest(
  /**
   *  * Block height near where receipt was created. Enables hint fallback
   * scan on column miss. Anchor refreshes to each scan-resolved parent's
   * exact execution height; later ancestors bounded via causality
   * (emit before execute), so subsequent column-miss scans go
   * `Ancestor`. Bump `receipt_to_tx_max_hop_distance` if cold archival
   * gaps exceed default 20.
   *
   * Cold-storage cost: per-row latency orders of magnitude over hot. To
   * bound request cost:
   *   - Supply `block_height` within parent's `±window` (default 5).
   *   - Supply `shard_id`. Omit → all-shards enumeration until walker
   *     crosses `FromReceipt` hop, multiplying cold-read cost.
   *   - Don't widen `window` beyond indexer's accuracy; budget shared
   *     across full ancestry walk.
   *
   * Receipt-id-only queries against periods with `save_receipt_to_tx`
   * disabled stay unsupported: column never written, no self-locating.
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("block_height")
  public val blockHeight: ULong? = null,
  @SerialName("receipt_id")
  public val receiptId: CryptoHash,
  /**
   *  * Shard hint. Narrows scan to this shard at hint height. Omit to
   * enumerate all tracked shards (higher cost). After walker crosses a
   * receipt-origin hop, shard derived from parent's predecessor account
   * and hint no longer applies. Best-effort across resharding: layout
   * shifts can miss producer, walk returns `UnknownReceipt`.
   */
  @SerialName("shard_id")
  public val shardId: ShardId? = null,
  /**
   *  * Pre-first-scan width: `±window` heights around hint. Caps at
   * `receipt_to_tx_max_hint_window` (default 20). Ignored after first
   * scan-resolved hop — walker switches to `Ancestor` mode at
   * `receipt_to_tx_max_hop_distance` width.
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("window")
  public val window: ULong? = null,
)
