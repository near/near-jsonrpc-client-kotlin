package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.collections.List
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.serializer

/**
 *  * Contains main info about the block.
 */
@Serializable
public data class BlockHeaderView(
  @SerialName("approvals")
  public val approvals: List<Signature?>,
  @SerialName("block_body_hash")
  public val blockBodyHash: CryptoHash? = null,
  @SerialName("block_merkle_root")
  public val blockMerkleRoot: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("block_ordinal")
  public val blockOrdinal: ULong? = null,
  @SerialName("challenges_result")
  public val challengesResult: List<SlashedValidator>,
  @SerialName("challenges_root")
  public val challengesRoot: CryptoHash,
  /**
   *  * Nullable: true
   */
  @SerialName("chunk_endorsements")
  public val chunkEndorsements: List<List<UByte>>? = null,
  @SerialName("chunk_execution_root")
  public val chunkExecutionRoot: CryptoHash? = null,
  @SerialName("chunk_headers_root")
  public val chunkHeadersRoot: CryptoHash,
  @SerialName("chunk_mask")
  public val chunkMask: List<Boolean>,
  @SerialName("chunk_receipts_root")
  public val chunkReceiptsRoot: CryptoHash,
  @SerialName("chunk_tx_root")
  public val chunkTxRoot: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("chunks_included")
  public val chunksIncluded: ULong,
  @SerialName("epoch_id")
  public val epochId: CryptoHash,
  @SerialName("epoch_sync_data_hash")
  public val epochSyncDataHash: CryptoHash? = null,
  @SerialName("gas_price")
  public val gasPrice: NearToken,
  @SerialName("hash")
  public val hash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("height")
  public val height: ULong,
  @SerialName("last_ds_final_block")
  public val lastDsFinalBlock: CryptoHash,
  @SerialName("last_final_block")
  public val lastFinalBlock: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint32
   */
  @SerialName("latest_protocol_version")
  public val latestProtocolVersion: UInt,
  @SerialName("next_bp_hash")
  public val nextBpHash: CryptoHash,
  @SerialName("next_epoch_id")
  public val nextEpochId: CryptoHash,
  @SerialName("outcome_root")
  public val outcomeRoot: CryptoHash,
  /**
   *  * The hash of the previous Block
   */
  @SerialName("prev_hash")
  public val prevHash: CryptoHash,
  /**
   *  * Minimum: 0.0
   *  * Format: uint64
   *  * Nullable: true
   */
  @SerialName("prev_height")
  public val prevHeight: ULong? = null,
  @SerialName("prev_last_certified_block_epoch_id")
  public val prevLastCertifiedBlockEpochId: EpochId? = null,
  @SerialName("prev_state_root")
  public val prevStateRoot: CryptoHash,
  @SerialName("random_value")
  public val randomValue: CryptoHash,
  /**
   *  * TODO(2271): deprecated.
   */
  @SerialName("rent_paid")
  public val rentPaid: NearToken? = NearToken("0"),
  /**
   *  * Min Items: 2
   *  * Max Items: 2
   *  * Nullable: true
   */
  @SerialName("shard_split")
  public val shardSplit: ShardSplitTuple? = null,
  /**
   *  * Signature of the block producer.
   */
  @SerialName("signature")
  public val signature: Signature,
  /**
   *  * Nullable: true
   */
  @SerialName("spice_chunk_endorsement_stats")
  public val spiceChunkEndorsementStats: List<SpiceChunkEndorsementStats>? = null,
  /**
   *  * Legacy json number. Should not be used.
   *  * Minimum: 0.0
   *  * Format: uint64
   */
  @SerialName("timestamp")
  public val timestamp: ULong,
  @SerialName("timestamp_nanosec")
  public val timestampNanosec: String,
  @SerialName("total_supply")
  public val totalSupply: NearToken,
  @SerialName("validator_proposals")
  public val validatorProposals: List<ValidatorStakeView>,
  /**
   *  * TODO(2271): deprecated.
   */
  @SerialName("validator_reward")
  public val validatorReward: NearToken? = NearToken("0"),
) {
  /**
   *  * Min Items: 2
   *  * Max Items: 2
   *  * Nullable: true
   */
  @Serializable(with = ShardSplitTuple.TupleSerializer::class)
  public data class ShardSplitTuple(
    public val item0: ShardId,
    public val item1: AccountId,
  ) {
    @OptIn(InternalSerializationApi::class)
    public object TupleSerializer : KSerializer<ShardSplitTuple> {
      override val descriptor: SerialDescriptor =
          buildSerialDescriptor("ShardSplitTuple", StructureKind.LIST)

      override fun serialize(encoder: Encoder, `value`: ShardSplitTuple) {
        if (encoder !is JsonEncoder) throw SerializationException("Cannot serialize ShardSplitTuple with non-JSON encoder")
        val json = encoder.json
        val list = buildList<JsonElement> {
          add(json.encodeToJsonElement(serializer<ShardId>(), value.item0))
          add(json.encodeToJsonElement(serializer<AccountId>(), value.item1))
        }
        encoder.encodeJsonElement(JsonArray(list))
      }

      override fun deserialize(decoder: Decoder): ShardSplitTuple {
        if (decoder !is JsonDecoder) throw SerializationException("Cannot deserialize ShardSplitTuple with non-JSON decoder")
        val element = decoder.decodeJsonElement()
        val arr = element as? JsonArray ?: throw SerializationException("Expected JSON array for ShardSplitTuple")
        if (arr.size != 2) throw SerializationException("Expected 2 items for ShardSplitTuple")
        val item0 = decoder.json.decodeFromJsonElement(serializer<ShardId>(), arr[0])
        val item1 = decoder.json.decodeFromJsonElement(serializer<AccountId>(), arr[1])
        return ShardSplitTuple(item0, item1)
      }
    }
  }
}
