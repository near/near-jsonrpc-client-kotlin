package io.github.hosseinkarami_dev.near.rpc.models

import io.github.hosseinkarami_dev.near.rpc.serializers.RpcValidatorRequestSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable(with = RpcValidatorRequestSerializer::class)
public sealed class RpcValidatorRequest {
  @Serializable
  public data class EpochId(
    @SerialName("epoch_id")
    public val epochId: io.github.hosseinkarami_dev.near.rpc.models.EpochId,
  ) : RpcValidatorRequest()

  @Serializable
  public data class BlockId(
    @SerialName("block_id")
    public val blockId: io.github.hosseinkarami_dev.near.rpc.models.BlockId,
  ) : RpcValidatorRequest()

  @Serializable
  public data class Latest(
    /**
     *  * Nullable: true
     *  * Possible values: null
     */
    @SerialName("latest")
    public val latest: JsonElement? = null,
  ) : RpcValidatorRequest()
}
