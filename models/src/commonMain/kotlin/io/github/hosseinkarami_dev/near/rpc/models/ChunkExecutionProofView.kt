package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Proof that a chunk's certified execution roots are committed by a spice block
 * that a light client can trust via its `light_client_head`.
 *
 * `roots_proof` recomputes the certifying block's `chunk_execution_root` from the leaf;
 * `certifying_block_proof` places the certifying block into the head's block merkle tree.
 */
@Serializable
public data class ChunkExecutionProofView(
  @SerialName("certifying_block_header_lite")
  public val certifyingBlockHeaderLite: LightClientBlockLiteView,
  @SerialName("certifying_block_proof")
  public val certifyingBlockProof: List<MerklePathItem>,
  @SerialName("roots")
  public val roots: ChunkExecutionRoots,
  @SerialName("roots_proof")
  public val rootsProof: List<MerklePathItem>,
)
