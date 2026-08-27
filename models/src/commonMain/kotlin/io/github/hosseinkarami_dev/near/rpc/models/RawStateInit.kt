package io.github.hosseinkarami_dev.near.rpc.models

import kotlin.String
import kotlin.jvm.JvmInline
import kotlinx.serialization.Serializable

/**
 *  * Raw bytes containing borsh-serialized `UniversalStateInit`.
 *
 * This is the protocol's view of a state init, not a mere transport wrapper: the
 * account ID is SHA3-256 over exactly these bytes. The typed form is a decoded
 * *view* of them, used to install the state and to price the action, and it is
 * never re-serialized to derive an ID. Two encodings of the same logical value
 * are two different accounts, which is deliberate: canonical encoding cannot be
 * enforced end to end anyway, since contracts serialize their own nested state
 * inside the opaque storage values.
 *
 * It also lets an immutable contract pass through a `UniversalStateInit` version it
 * predates: the bytes travel verbatim, so a version added after the contract was
 * compiled still works.
 *
 * Borsh-serializing `RawStateInit` writes a 4-byte length prefix before the
 * bytes, which is how the `UniversalStateInit` action carries it as a field;
 * over serde the bytes are base64. Neither is what the account ID hashes: that
 * is `self.0` alone, never `borsh::to_vec(self)`.
 */
@Serializable
@JvmInline
public value class RawStateInit(
  public val `value`: String,
)
