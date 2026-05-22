package io.github.hosseinkarami_dev.near.rpc.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  * Describes information about an access key including its on-trie
 * identifier. For ed25519/secp256k1 access keys the `public_key` field
 * is the full public key (string form unchanged from before); for
 * ML-DSA-65 access keys it is a `ml-dsa-65-hash:...` SHA3-384 digest
 * (the full pubkey is not stored on-chain).
 */
@Serializable
public data class AccessKeyInfoView(
  @SerialName("access_key")
  public val accessKey: AccessKeyView,
  @SerialName("public_key")
  public val publicKey: KeyHandle,
)
