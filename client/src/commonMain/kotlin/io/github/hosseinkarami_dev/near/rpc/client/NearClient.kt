package io.github.hosseinkarami_dev.near.rpc.client

import io.github.hosseinkarami_dev.near.rpc.client.callRpc
import io.github.hosseinkarami_dev.near.rpc.models.CryptoHash
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForGenesisConfigError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcBlockError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcCallFunctionError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcChunkError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcClientConfigError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcGasPriceError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientNextBlockError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcLightClientProofError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcMaintenanceWindowsError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcNetworkInfoError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcProtocolConfigError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcQueryError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcReceiptError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcReceiptToTxError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcSplitStorageInfoError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcStateChangesError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcStatusError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcTransactionError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcValidatorError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccessKeyError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccessKeyListError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewAccountError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewCodeError
import io.github.hosseinkarami_dev.near.rpc.models.ErrorWrapperForRpcViewStateError
import io.github.hosseinkarami_dev.near.rpc.models.GenesisConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlock
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBlockEffects
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxAsync
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForBroadcastTxCommit
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChanges
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForChunk
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForClientConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalCallFunction
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChanges
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalChangesInBlock
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalCongestionLevel
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalGenesisConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientBlockProof
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalLightClientProof
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalMaintenanceWindows
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalProtocolConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalReceipt
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalReceiptToTx
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalSplitStorageInfo
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalTxStatus
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalValidatorsOrdered
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalViewAccessKey
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalViewAccessKeyList
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalViewAccount
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalViewCode
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForExperimentalViewState
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGasPrice
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForGenesisConfig
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForHealth
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForLightClientProof
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForMaintenanceWindows
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNetworkInfo
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForNextLightClientBlock
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForQuery
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForSendTx
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForStatus
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForTx
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcRequestForValidators
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForCryptoHashAndRpcTransactionError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForGenesisConfigAndGenesisConfigError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcBlockResponseAndRpcBlockError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcChunkResponseAndRpcChunkError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcQueryResponseAndRpcQueryError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcStatusResponseAndRpcStatusError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeError
import io.github.hosseinkarami_dev.near.rpc.models.JsonRpcResponseForRpcViewStateResponseAndRpcViewStateError
import io.github.hosseinkarami_dev.near.rpc.models.RangeOfUint64
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcChunkResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcClientConfigResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcHealthResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcNetworkInfoResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcQueryResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcSplitStorageInfoResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcStatusResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeResponse
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest
import io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateResponse
import io.github.hosseinkarami_dev.near.rpc.models.ValidatorStakeView
import io.ktor.client.HttpClient
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.json.JsonObject

public class NearClient(
  private val httpClient: HttpClient,
  private val baseUrl: String,
) {
  private fun nextId(): String = "dontcare"

  /**
   * Calls a view function on a contract and returns the result.
   *
   * @see path: /EXPERIMENTAL_call_function (method: post) — operationId: EXPERIMENTAL_call_function
   *
   * @param rpcCallFunctionRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcCallFunctionRequest` (required).
   * @return Response: `RpcResponse<RpcCallFunctionResponse>`.
   */
  public suspend fun experimentalCallFunction(rpcCallFunctionRequest: RpcCallFunctionRequest): RpcResponse<RpcCallFunctionResponse> {
    val request = JsonRpcRequestForExperimentalCallFunction(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalCallFunction.Method.EXPERIMENTAL_CALL_FUNCTION,
      params = rpcCallFunctionRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalCallFunction.serializer(),
        JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionError.serializer(),
        ErrorWrapperForRpcCallFunctionError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcCallFunctionResponseAndRpcCallFunctionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * [Deprecated] Returns changes for a given account, contract or contract code for given block height or hash. Consider using changes instead.
   *
   * @see path: /EXPERIMENTAL_changes (method: post) — operationId: EXPERIMENTAL_changes
   *
   * @param rpcStateChangesInBlockByTypeRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest` (required).
   * @return Response: `RpcResponse<RpcStateChangesInBlockResponse>`.
   */
  @Deprecated(
    message = "[Deprecated] Returns changes for a given account, contract or contract code for given block height or hash. Consider using changes instead. — deprecated.",
    replaceWith = ReplaceWith("changes(rpcStateChangesInBlockByTypeRequest)"),
    level = DeprecationLevel.WARNING,
  )
  public suspend fun experimentalChanges(rpcStateChangesInBlockByTypeRequest: RpcStateChangesInBlockByTypeRequest): RpcResponse<RpcStateChangesInBlockResponse> {
    val request = JsonRpcRequestForExperimentalChanges(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalChanges.Method.EXPERIMENTAL_CHANGES,
      params = rpcStateChangesInBlockByTypeRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalChanges.serializer(),
        JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.serializer(),
        ErrorWrapperForRpcStateChangesError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * [Deprecated] Returns changes in block for given block height or hash over all transactions for all the types. Includes changes like account_touched, access_key_touched, data_touched, contract_code_touched. Consider using block_effects instead
   *
   * @see path: /EXPERIMENTAL_changes_in_block (method: post) — operationId: EXPERIMENTAL_changes_in_block
   *
   * @param rpcStateChangesInBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest` (required).
   * @return Response: `RpcResponse<RpcStateChangesInBlockByTypeResponse>`.
   */
  @Deprecated(
    message = "[Deprecated] Returns changes in block for given block height or hash over all transactions for all the types. Includes changes like account_touched, access_key_touched, data_touched, contract_code_touched. Consider using block_effects instead — deprecated.",
    replaceWith = ReplaceWith("blockEffects(rpcStateChangesInBlockRequest)"),
    level = DeprecationLevel.WARNING,
  )
  public suspend fun experimentalChangesInBlock(rpcStateChangesInBlockRequest: RpcStateChangesInBlockRequest): RpcResponse<RpcStateChangesInBlockByTypeResponse> {
    val request = JsonRpcRequestForExperimentalChangesInBlock(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalChangesInBlock.Method.EXPERIMENTAL_CHANGES_IN_BLOCK,
      params = rpcStateChangesInBlockRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalChangesInBlock.serializer(),
        JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.serializer(),
        ErrorWrapperForRpcStateChangesError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Queries the congestion level of a shard. More info about congestion [here](https://near.github.io/nearcore/architecture/how/receipt-congestion.html?highlight=congestion#receipt-congestion)
   *
   * @see path: /EXPERIMENTAL_congestion_level (method: post) — operationId: EXPERIMENTAL_congestion_level
   *
   * @param rpcCongestionLevelRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcCongestionLevelRequest` (required).
   * @return Response: `RpcResponse<RpcCongestionLevelResponse>`.
   */
  public suspend fun experimentalCongestionLevel(rpcCongestionLevelRequest: RpcCongestionLevelRequest): RpcResponse<RpcCongestionLevelResponse> {
    val request = JsonRpcRequestForExperimentalCongestionLevel(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalCongestionLevel.Method.EXPERIMENTAL_CONGESTION_LEVEL,
      params = rpcCongestionLevelRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalCongestionLevel.serializer(),
        JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.serializer(),
        ErrorWrapperForRpcChunkError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcCongestionLevelResponseAndRpcChunkError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * [Deprecated] Get initial state and parameters for the genesis block. Consider genesis_config instead.
   *
   * @see path: /EXPERIMENTAL_genesis_config (method: post) — operationId: EXPERIMENTAL_genesis_config
   *
   * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
   * @return Response: `RpcResponse<GenesisConfig>`.
   */
  @Deprecated(
    message = "[Deprecated] Get initial state and parameters for the genesis block. Consider genesis_config instead. — deprecated.",
    level = DeprecationLevel.WARNING,
  )
  public suspend fun experimentalGenesisConfig(): RpcResponse<GenesisConfig> {
    val request = JsonRpcRequestForExperimentalGenesisConfig(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalGenesisConfig.Method.EXPERIMENTAL_GENESIS_CONFIG,
      params = null
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalGenesisConfig.serializer(),
        JsonRpcResponseForGenesisConfigAndGenesisConfigError.serializer(),
        ErrorWrapperForGenesisConfigError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the proofs for a transaction execution.
   *
   * @see path: /EXPERIMENTAL_light_client_block_proof (method: post) — operationId: EXPERIMENTAL_light_client_block_proof
   *
   * @param rpcLightClientBlockProofRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientBlockProofRequest` (required).
   * @return Response: `RpcResponse<RpcLightClientBlockProofResponse>`.
   */
  public suspend fun experimentalLightClientBlockProof(rpcLightClientBlockProofRequest: RpcLightClientBlockProofRequest): RpcResponse<RpcLightClientBlockProofResponse> {
    val request = JsonRpcRequestForExperimentalLightClientBlockProof(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalLightClientBlockProof.Method.EXPERIMENTAL_LIGHT_CLIENT_BLOCK_PROOF,
      params = rpcLightClientBlockProofRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalLightClientBlockProof.serializer(),
        JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError.serializer(),
        ErrorWrapperForRpcLightClientProofError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcLightClientBlockProofResponseAndRpcLightClientProofError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the proofs for a transaction execution.
   *
   * @see path: /EXPERIMENTAL_light_client_proof (method: post) — operationId: EXPERIMENTAL_light_client_proof
   *
   * @param rpcLightClientExecutionProofRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest` (required).
   * @return Response: `RpcResponse<RpcLightClientExecutionProofResponse>`.
   */
  public suspend fun experimentalLightClientProof(rpcLightClientExecutionProofRequest: RpcLightClientExecutionProofRequest): RpcResponse<RpcLightClientExecutionProofResponse> {
    val request = JsonRpcRequestForExperimentalLightClientProof(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalLightClientProof.Method.EXPERIMENTAL_LIGHT_CLIENT_PROOF,
      params = rpcLightClientExecutionProofRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalLightClientProof.serializer(),
        JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.serializer(),
        ErrorWrapperForRpcLightClientProofError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * [Deprecated] Returns the future windows for maintenance in current epoch for the specified account. In the maintenance windows, the node will not be block producer or chunk producer. Consider using maintenance_windows instead.
   *
   * @see path: /EXPERIMENTAL_maintenance_windows (method: post) — operationId: EXPERIMENTAL_maintenance_windows
   *
   * @param rpcMaintenanceWindowsRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest` (required).
   * @return Response: `RpcResponse<List<RangeOfUint64>>`.
   */
  @Deprecated(
    message = "[Deprecated] Returns the future windows for maintenance in current epoch for the specified account. In the maintenance windows, the node will not be block producer or chunk producer. Consider using maintenance_windows instead. — deprecated.",
    replaceWith = ReplaceWith("maintenanceWindows(rpcMaintenanceWindowsRequest)"),
    level = DeprecationLevel.WARNING,
  )
  public suspend fun experimentalMaintenanceWindows(rpcMaintenanceWindowsRequest: RpcMaintenanceWindowsRequest): RpcResponse<List<RangeOfUint64>> {
    val request = JsonRpcRequestForExperimentalMaintenanceWindows(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalMaintenanceWindows.Method.EXPERIMENTAL_MAINTENANCE_WINDOWS,
      params = rpcMaintenanceWindowsRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalMaintenanceWindows.serializer(),
        JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.serializer(),
        ErrorWrapperForRpcMaintenanceWindowsError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * A configuration that defines the protocol-level parameters such as gas/storage costs, limits, feature flags, other settings
   *
   * @see path: /EXPERIMENTAL_protocol_config (method: post) — operationId: EXPERIMENTAL_protocol_config
   *
   * @param rpcProtocolConfigRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcProtocolConfigRequest` (required).
   * @return Response: `RpcResponse<RpcProtocolConfigResponse>`.
   */
  public suspend fun experimentalProtocolConfig(rpcProtocolConfigRequest: RpcProtocolConfigRequest): RpcResponse<RpcProtocolConfigResponse> {
    val request = JsonRpcRequestForExperimentalProtocolConfig(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalProtocolConfig.Method.EXPERIMENTAL_PROTOCOL_CONFIG,
      params = rpcProtocolConfigRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalProtocolConfig.serializer(),
        JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.serializer(),
        ErrorWrapperForRpcProtocolConfigError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcProtocolConfigResponseAndRpcProtocolConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Fetches a receipt by its ID (as is, without a status or execution outcome)
   *
   * @see path: /EXPERIMENTAL_receipt (method: post) — operationId: EXPERIMENTAL_receipt
   *
   * @param rpcReceiptRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptRequest` (required).
   * @return Response: `RpcResponse<RpcReceiptResponse>`.
   */
  public suspend fun experimentalReceipt(rpcReceiptRequest: RpcReceiptRequest): RpcResponse<RpcReceiptResponse> {
    val request = JsonRpcRequestForExperimentalReceipt(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalReceipt.Method.EXPERIMENTAL_RECEIPT,
      params = rpcReceiptRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalReceipt.serializer(),
        JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError.serializer(),
        ErrorWrapperForRpcReceiptError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcReceiptResponseAndRpcReceiptError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Resolves a receipt ID back to the originating transaction hash and sender account
   *
   * @see path: /EXPERIMENTAL_receipt_to_tx (method: post) — operationId: EXPERIMENTAL_receipt_to_tx
   *
   * @param rpcReceiptToTxRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcReceiptToTxRequest` (required).
   * @return Response: `RpcResponse<RpcReceiptToTxResponse>`.
   */
  public suspend fun experimentalReceiptToTx(rpcReceiptToTxRequest: RpcReceiptToTxRequest): RpcResponse<RpcReceiptToTxResponse> {
    val request = JsonRpcRequestForExperimentalReceiptToTx(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalReceiptToTx.Method.EXPERIMENTAL_RECEIPT_TO_TX,
      params = rpcReceiptToTxRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalReceiptToTx.serializer(),
        JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError.serializer(),
        ErrorWrapperForRpcReceiptToTxError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcReceiptToTxResponseAndRpcReceiptToTxError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Contains the split storage information. More info on split storage [here](https://near-nodes.io/archival/split-storage-archival)
   *
   * @see path: /EXPERIMENTAL_split_storage_info (method: post) — operationId: EXPERIMENTAL_split_storage_info
   *
   * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
   * @return Response: `RpcResponse<RpcSplitStorageInfoResponse>`.
   */
  public suspend fun experimentalSplitStorageInfo(): RpcResponse<RpcSplitStorageInfoResponse> {
    val request = JsonRpcRequestForExperimentalSplitStorageInfo(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalSplitStorageInfo.Method.EXPERIMENTAL_SPLIT_STORAGE_INFO,
      params = RpcSplitStorageInfoRequest(value = JsonObject(emptyMap()))
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalSplitStorageInfo.serializer(),
        JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.serializer(),
        ErrorWrapperForRpcSplitStorageInfoError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcSplitStorageInfoResponseAndRpcSplitStorageInfoError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Queries status of a transaction by hash, returning the final transaction result and details of all receipts.
   *
   * @see path: /EXPERIMENTAL_tx_status (method: post) — operationId: EXPERIMENTAL_tx_status
   *
   * @param rpcTransactionStatusRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest` (required).
   * @return Response: `RpcResponse<RpcTransactionResponse>`.
   */
  public suspend fun experimentalTxStatus(rpcTransactionStatusRequest: RpcTransactionStatusRequest): RpcResponse<RpcTransactionResponse> {
    val request = JsonRpcRequestForExperimentalTxStatus(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalTxStatus.Method.EXPERIMENTAL_TX_STATUS,
      params = rpcTransactionStatusRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalTxStatus.serializer(),
        JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(),
        ErrorWrapperForRpcTransactionError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the current epoch validators ordered in the block producer order with repetition. This endpoint is solely used for bridge currently and is not intended for other external use cases.
   *
   * @see path: /EXPERIMENTAL_validators_ordered (method: post) — operationId: EXPERIMENTAL_validators_ordered
   *
   * @param rpcValidatorsOrderedRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorsOrderedRequest` (required).
   * @return Response: `RpcResponse<List<ValidatorStakeView>>`.
   */
  public suspend fun experimentalValidatorsOrdered(rpcValidatorsOrderedRequest: RpcValidatorsOrderedRequest): RpcResponse<List<ValidatorStakeView>> {
    val request = JsonRpcRequestForExperimentalValidatorsOrdered(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalValidatorsOrdered.Method.EXPERIMENTAL_VALIDATORS_ORDERED,
      params = rpcValidatorsOrderedRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalValidatorsOrdered.serializer(),
        JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError.serializer(),
        ErrorWrapperForRpcValidatorError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForArrayOfValidatorStakeViewAndRpcValidatorError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns information about a single access key for given account.
   *
   * @see path: /EXPERIMENTAL_view_access_key (method: post) — operationId: EXPERIMENTAL_view_access_key
   *
   * @param rpcViewAccessKeyRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyRequest` (required).
   * @return Response: `RpcResponse<RpcViewAccessKeyResponse>`.
   */
  public suspend fun experimentalViewAccessKey(rpcViewAccessKeyRequest: RpcViewAccessKeyRequest): RpcResponse<RpcViewAccessKeyResponse> {
    val request = JsonRpcRequestForExperimentalViewAccessKey(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalViewAccessKey.Method.EXPERIMENTAL_VIEW_ACCESS_KEY,
      params = rpcViewAccessKeyRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalViewAccessKey.serializer(),
        JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError.serializer(),
        ErrorWrapperForRpcViewAccessKeyError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcViewAccessKeyResponseAndRpcViewAccessKeyError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns all access keys for a given account.
   *
   * @see path: /EXPERIMENTAL_view_access_key_list (method: post) — operationId: EXPERIMENTAL_view_access_key_list
   *
   * @param rpcViewAccessKeyListRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccessKeyListRequest` (required).
   * @return Response: `RpcResponse<RpcViewAccessKeyListResponse>`.
   */
  public suspend fun experimentalViewAccessKeyList(rpcViewAccessKeyListRequest: RpcViewAccessKeyListRequest): RpcResponse<RpcViewAccessKeyListResponse> {
    val request = JsonRpcRequestForExperimentalViewAccessKeyList(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalViewAccessKeyList.Method.EXPERIMENTAL_VIEW_ACCESS_KEY_LIST,
      params = rpcViewAccessKeyListRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalViewAccessKeyList.serializer(),
        JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListError.serializer(),
        ErrorWrapperForRpcViewAccessKeyListError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcViewAccessKeyListResponseAndRpcViewAccessKeyListError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns information about an account for given account_id.
   *
   * @see path: /EXPERIMENTAL_view_account (method: post) — operationId: EXPERIMENTAL_view_account
   *
   * @param rpcViewAccountRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcViewAccountRequest` (required).
   * @return Response: `RpcResponse<RpcViewAccountResponse>`.
   */
  public suspend fun experimentalViewAccount(rpcViewAccountRequest: RpcViewAccountRequest): RpcResponse<RpcViewAccountResponse> {
    val request = JsonRpcRequestForExperimentalViewAccount(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalViewAccount.Method.EXPERIMENTAL_VIEW_ACCOUNT,
      params = rpcViewAccountRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalViewAccount.serializer(),
        JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountError.serializer(),
        ErrorWrapperForRpcViewAccountError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcViewAccountResponseAndRpcViewAccountError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the contract code (Wasm binary) deployed to the account.
   *
   * @see path: /EXPERIMENTAL_view_code (method: post) — operationId: EXPERIMENTAL_view_code
   *
   * @param rpcViewCodeRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcViewCodeRequest` (required).
   * @return Response: `RpcResponse<RpcViewCodeResponse>`.
   */
  public suspend fun experimentalViewCode(rpcViewCodeRequest: RpcViewCodeRequest): RpcResponse<RpcViewCodeResponse> {
    val request = JsonRpcRequestForExperimentalViewCode(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalViewCode.Method.EXPERIMENTAL_VIEW_CODE,
      params = rpcViewCodeRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalViewCode.serializer(),
        JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeError.serializer(),
        ErrorWrapperForRpcViewCodeError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcViewCodeResponseAndRpcViewCodeError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the state (key-value pairs) of a contract based on the key prefix.
   *
   * @see path: /EXPERIMENTAL_view_state (method: post) — operationId: EXPERIMENTAL_view_state
   *
   * @param rpcViewStateRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcViewStateRequest` (required).
   * @return Response: `RpcResponse<RpcViewStateResponse>`.
   */
  public suspend fun experimentalViewState(rpcViewStateRequest: RpcViewStateRequest): RpcResponse<RpcViewStateResponse> {
    val request = JsonRpcRequestForExperimentalViewState(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForExperimentalViewState.Method.EXPERIMENTAL_VIEW_STATE,
      params = rpcViewStateRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForExperimentalViewState.serializer(),
        JsonRpcResponseForRpcViewStateResponseAndRpcViewStateError.serializer(),
        ErrorWrapperForRpcViewStateError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcViewStateResponseAndRpcViewStateError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcViewStateResponseAndRpcViewStateError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns block details for given height or hash
   *
   * @see path: /block (method: post) — operationId: block
   *
   * @param rpcBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcBlockRequest` (required).
   * @return Response: `RpcResponse<RpcBlockResponse>`.
   */
  public suspend fun block(rpcBlockRequest: RpcBlockRequest): RpcResponse<RpcBlockResponse> {
    val request = JsonRpcRequestForBlock(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForBlock.Method.BLOCK,
      params = rpcBlockRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForBlock.serializer(),
        JsonRpcResponseForRpcBlockResponseAndRpcBlockError.serializer(),
        ErrorWrapperForRpcBlockError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcBlockResponseAndRpcBlockError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcBlockResponseAndRpcBlockError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns changes in block for given block height or hash over all transactions for all the types. Includes changes like account_touched, access_key_touched, data_touched, contract_code_touched.
   *
   * @see path: /block_effects (method: post) — operationId: block_effects
   *
   * @param rpcStateChangesInBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockRequest` (required).
   * @return Response: `RpcResponse<RpcStateChangesInBlockByTypeResponse>`.
   */
  public suspend fun blockEffects(rpcStateChangesInBlockRequest: RpcStateChangesInBlockRequest): RpcResponse<RpcStateChangesInBlockByTypeResponse> {
    val request = JsonRpcRequestForBlockEffects(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForBlockEffects.Method.BLOCK_EFFECTS,
      params = rpcStateChangesInBlockRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForBlockEffects.serializer(),
        JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.serializer(),
        ErrorWrapperForRpcStateChangesError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcStateChangesInBlockByTypeResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * [Deprecated] Sends a transaction and immediately returns transaction hash. Consider using send_tx instead.
   *
   * @see path: /broadcast_tx_async (method: post) — operationId: broadcast_tx_async
   *
   * @param rpcSendTransactionRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest` (required).
   * @return Response: `RpcResponse<CryptoHash>`.
   */
  @Deprecated(
    message = "[Deprecated] Sends a transaction and immediately returns transaction hash. Consider using send_tx instead. — deprecated.",
    replaceWith = ReplaceWith("sendTx(rpcSendTransactionRequest)"),
    level = DeprecationLevel.WARNING,
  )
  public suspend fun broadcastTxAsync(rpcSendTransactionRequest: RpcSendTransactionRequest): RpcResponse<CryptoHash> {
    val request = JsonRpcRequestForBroadcastTxAsync(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForBroadcastTxAsync.Method.BROADCAST_TX_ASYNC,
      params = rpcSendTransactionRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForBroadcastTxAsync.serializer(),
        JsonRpcResponseForCryptoHashAndRpcTransactionError.serializer(),
        ErrorWrapperForRpcTransactionError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForCryptoHashAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForCryptoHashAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * [Deprecated] Sends a transaction and waits until transaction is fully complete. (Has a 10 second timeout). Consider using send_tx instead.
   *
   * @see path: /broadcast_tx_commit (method: post) — operationId: broadcast_tx_commit
   *
   * @param rpcSendTransactionRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest` (required).
   * @return Response: `RpcResponse<RpcTransactionResponse>`.
   */
  @Deprecated(
    message = "[Deprecated] Sends a transaction and waits until transaction is fully complete. (Has a 10 second timeout). Consider using send_tx instead. — deprecated.",
    replaceWith = ReplaceWith("sendTx(rpcSendTransactionRequest)"),
    level = DeprecationLevel.WARNING,
  )
  public suspend fun broadcastTxCommit(rpcSendTransactionRequest: RpcSendTransactionRequest): RpcResponse<RpcTransactionResponse> {
    val request = JsonRpcRequestForBroadcastTxCommit(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForBroadcastTxCommit.Method.BROADCAST_TX_COMMIT,
      params = rpcSendTransactionRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForBroadcastTxCommit.serializer(),
        JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(),
        ErrorWrapperForRpcTransactionError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns changes for a given account, contract or contract code for given block height or hash.
   *
   * @see path: /changes (method: post) — operationId: changes
   *
   * @param rpcStateChangesInBlockByTypeRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcStateChangesInBlockByTypeRequest` (required).
   * @return Response: `RpcResponse<RpcStateChangesInBlockResponse>`.
   */
  public suspend fun changes(rpcStateChangesInBlockByTypeRequest: RpcStateChangesInBlockByTypeRequest): RpcResponse<RpcStateChangesInBlockResponse> {
    val request = JsonRpcRequestForChanges(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForChanges.Method.CHANGES,
      params = rpcStateChangesInBlockByTypeRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForChanges.serializer(),
        JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.serializer(),
        ErrorWrapperForRpcStateChangesError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcStateChangesInBlockResponseAndRpcStateChangesError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns details of a specific chunk. You can run a block details query to get a valid chunk hash.
   *
   * @see path: /chunk (method: post) — operationId: chunk
   *
   * @param rpcChunkRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcChunkRequest` (required).
   * @return Response: `RpcResponse<RpcChunkResponse>`.
   */
  public suspend fun chunk(rpcChunkRequest: RpcChunkRequest): RpcResponse<RpcChunkResponse> {
    val request = JsonRpcRequestForChunk(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForChunk.Method.CHUNK,
      params = rpcChunkRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForChunk.serializer(),
        JsonRpcResponseForRpcChunkResponseAndRpcChunkError.serializer(),
        ErrorWrapperForRpcChunkError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcChunkResponseAndRpcChunkError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcChunkResponseAndRpcChunkError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Queries client node configuration
   *
   * @see path: /client_config (method: post) — operationId: client_config
   *
   * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
   * @return Response: `RpcResponse<RpcClientConfigResponse>`.
   */
  public suspend fun clientConfig(): RpcResponse<RpcClientConfigResponse> {
    val request = JsonRpcRequestForClientConfig(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForClientConfig.Method.CLIENT_CONFIG,
      params = null
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForClientConfig.serializer(),
        JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError.serializer(),
        ErrorWrapperForRpcClientConfigError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcClientConfigResponseAndRpcClientConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns gas price for a specific block_height or block_hash. Using [null] will return the most recent block's gas price.
   *
   * @see path: /gas_price (method: post) — operationId: gas_price
   *
   * @param rpcGasPriceRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcGasPriceRequest` (required).
   * @return Response: `RpcResponse<RpcGasPriceResponse>`.
   */
  public suspend fun gasPrice(rpcGasPriceRequest: RpcGasPriceRequest): RpcResponse<RpcGasPriceResponse> {
    val request = JsonRpcRequestForGasPrice(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForGasPrice.Method.GAS_PRICE,
      params = rpcGasPriceRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForGasPrice.serializer(),
        JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError.serializer(),
        ErrorWrapperForRpcGasPriceError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcGasPriceResponseAndRpcGasPriceError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Get initial state and parameters for the genesis block
   *
   * @see path: /genesis_config (method: post) — operationId: genesis_config
   *
   * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
   * @return Response: `RpcResponse<GenesisConfig>`.
   */
  public suspend fun genesisConfig(): RpcResponse<GenesisConfig> {
    val request = JsonRpcRequestForGenesisConfig(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForGenesisConfig.Method.GENESIS_CONFIG,
      params = null
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForGenesisConfig.serializer(),
        JsonRpcResponseForGenesisConfigAndGenesisConfigError.serializer(),
        ErrorWrapperForGenesisConfigError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForGenesisConfigAndGenesisConfigError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the current health status of the RPC node the client connects to.
   *
   * @see path: /health (method: post) — operationId: health
   *
   * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
   * @return Response: `RpcResponse<RpcHealthResponse>`.
   */
  public suspend fun health(): RpcResponse<RpcHealthResponse> {
    val request = JsonRpcRequestForHealth(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForHealth.Method.HEALTH,
      params = null
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForHealth.serializer(),
        JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError.serializer(),
        ErrorWrapperForRpcStatusError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForNullableRpcHealthResponseAndRpcStatusError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the proofs for a transaction execution.
   *
   * @see path: /light_client_proof (method: post) — operationId: light_client_proof
   *
   * @param rpcLightClientExecutionProofRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientExecutionProofRequest` (required).
   * @return Response: `RpcResponse<RpcLightClientExecutionProofResponse>`.
   */
  public suspend fun lightClientProof(rpcLightClientExecutionProofRequest: RpcLightClientExecutionProofRequest): RpcResponse<RpcLightClientExecutionProofResponse> {
    val request = JsonRpcRequestForLightClientProof(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForLightClientProof.Method.LIGHT_CLIENT_PROOF,
      params = rpcLightClientExecutionProofRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForLightClientProof.serializer(),
        JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.serializer(),
        ErrorWrapperForRpcLightClientProofError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcLightClientExecutionProofResponseAndRpcLightClientProofError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the future windows for maintenance in current epoch for the specified account. In the maintenance windows, the node will not be block producer or chunk producer.
   *
   * @see path: /maintenance_windows (method: post) — operationId: maintenance_windows
   *
   * @param rpcMaintenanceWindowsRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcMaintenanceWindowsRequest` (required).
   * @return Response: `RpcResponse<List<RangeOfUint64>>`.
   */
  public suspend fun maintenanceWindows(rpcMaintenanceWindowsRequest: RpcMaintenanceWindowsRequest): RpcResponse<List<RangeOfUint64>> {
    val request = JsonRpcRequestForMaintenanceWindows(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForMaintenanceWindows.Method.MAINTENANCE_WINDOWS,
      params = rpcMaintenanceWindowsRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForMaintenanceWindows.serializer(),
        JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.serializer(),
        ErrorWrapperForRpcMaintenanceWindowsError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForArrayOfRangeOfUint64AndRpcMaintenanceWindowsError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Queries the current state of node network connections. This includes information about active peers, transmitted data, known producers, etc.
   *
   * @see path: /network_info (method: post) — operationId: network_info
   *
   * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
   * @return Response: `RpcResponse<RpcNetworkInfoResponse>`.
   */
  public suspend fun networkInfo(): RpcResponse<RpcNetworkInfoResponse> {
    val request = JsonRpcRequestForNetworkInfo(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForNetworkInfo.Method.NETWORK_INFO,
      params = null
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForNetworkInfo.serializer(),
        JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.serializer(),
        ErrorWrapperForRpcNetworkInfoError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcNetworkInfoResponseAndRpcNetworkInfoError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Returns the next light client block.
   *
   * @see path: /next_light_client_block (method: post) — operationId: next_light_client_block
   *
   * @param rpcLightClientNextBlockRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcLightClientNextBlockRequest` (required).
   * @return Response: `RpcResponse<RpcLightClientNextBlockResponse>`.
   */
  public suspend fun nextLightClientBlock(rpcLightClientNextBlockRequest: RpcLightClientNextBlockRequest): RpcResponse<RpcLightClientNextBlockResponse> {
    val request = JsonRpcRequestForNextLightClientBlock(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForNextLightClientBlock.Method.NEXT_LIGHT_CLIENT_BLOCK,
      params = rpcLightClientNextBlockRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForNextLightClientBlock.serializer(),
        JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError.serializer(),
        ErrorWrapperForRpcLightClientNextBlockError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcLightClientNextBlockResponseAndRpcLightClientNextBlockError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * This module allows you to make generic requests to the network.
   *
   * The `RpcQueryRequest` struct takes in a [`BlockReference`](https://docs.rs/near-primitives/0.12.0/near_primitives/types/enum.BlockReference.html) and a [`QueryRequest`](https://docs.rs/near-primitives/0.12.0/near_primitives/views/enum.QueryRequest.html).
   *
   * The `BlockReference` enum allows you to specify a block by `Finality`, `BlockId` or `SyncCheckpoint`.
   *
   * The `QueryRequest` enum provides multiple variants for performing the following actions:
   *  - View an account's details
   *  - View a contract's code
   *  - View the state of an account
   *  - View the `AccessKey` of an account
   *  - View the `AccessKeyList` of an account
   *  - Call a function in a contract deployed on the network.
   *
   * @see path: /query (method: post) — operationId: query
   *
   * @param rpcQueryRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcQueryRequest` (required).
   * @return Response: `RpcResponse<RpcQueryResponse>`.
   */
  public suspend fun query(rpcQueryRequest: RpcQueryRequest): RpcResponse<RpcQueryResponse> {
    val request = JsonRpcRequestForQuery(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForQuery.Method.QUERY,
      params = rpcQueryRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForQuery.serializer(),
        JsonRpcResponseForRpcQueryResponseAndRpcQueryError.serializer(),
        ErrorWrapperForRpcQueryError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcQueryResponseAndRpcQueryError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcQueryResponseAndRpcQueryError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Sends transaction. Returns the guaranteed execution status and the results the blockchain can provide at the moment.
   *
   * @see path: /send_tx (method: post) — operationId: send_tx
   *
   * @param rpcSendTransactionRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcSendTransactionRequest` (required).
   * @return Response: `RpcResponse<RpcTransactionResponse>`.
   */
  public suspend fun sendTx(rpcSendTransactionRequest: RpcSendTransactionRequest): RpcResponse<RpcTransactionResponse> {
    val request = JsonRpcRequestForSendTx(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForSendTx.Method.SEND_TX,
      params = rpcSendTransactionRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForSendTx.serializer(),
        JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(),
        ErrorWrapperForRpcTransactionError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Requests the status of the connected RPC node. This includes information about sync status, nearcore node version, protocol version, the current set of validators, etc.
   *
   * @see path: /status (method: post) — operationId: status
   *
   * @param unit This method does not require params; the generator will send a default instance of the params wrapper in the JSON-RPC request.
   * @return Response: `RpcResponse<RpcStatusResponse>`.
   */
  public suspend fun status(): RpcResponse<RpcStatusResponse> {
    val request = JsonRpcRequestForStatus(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForStatus.Method.STATUS,
      params = null
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForStatus.serializer(),
        JsonRpcResponseForRpcStatusResponseAndRpcStatusError.serializer(),
        ErrorWrapperForRpcStatusError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcStatusResponseAndRpcStatusError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcStatusResponseAndRpcStatusError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Queries status of a transaction by hash and returns the final transaction result.
   *
   * @see path: /tx (method: post) — operationId: tx
   *
   * @param rpcTransactionStatusRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcTransactionStatusRequest` (required).
   * @return Response: `RpcResponse<RpcTransactionResponse>`.
   */
  public suspend fun tx(rpcTransactionStatusRequest: RpcTransactionStatusRequest): RpcResponse<RpcTransactionResponse> {
    val request = JsonRpcRequestForTx(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForTx.Method.TX,
      params = rpcTransactionStatusRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForTx.serializer(),
        JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.serializer(),
        ErrorWrapperForRpcTransactionError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcTransactionResponseAndRpcTransactionError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }

  /**
   * Queries active validators on the network. Returns details and the state of validation on the blockchain.
   *
   * @see path: /validators (method: post) — operationId: validators
   *
   * @param rpcValidatorRequest Request parameters: `io.github.hosseinkarami_dev.near.rpc.models.RpcValidatorRequest` (required).
   * @return Response: `RpcResponse<RpcValidatorResponse>`.
   */
  public suspend fun validators(rpcValidatorRequest: RpcValidatorRequest): RpcResponse<RpcValidatorResponse> {
    val request = JsonRpcRequestForValidators(
      id = nextId(),
      jsonrpc = "2.0",
      method = JsonRpcRequestForValidators.Method.VALIDATORS,
      params = rpcValidatorRequest
    )

    return callRpc(
        httpClient,
        baseUrl,
        request,
        JsonRpcRequestForValidators.serializer(),
        JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError.serializer(),
        ErrorWrapperForRpcValidatorError.serializer()
    ) { decoded ->
        when (decoded) {
            is JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError.Result -> RpcResponse.Success(decoded.result)
            is JsonRpcResponseForRpcValidatorResponseAndRpcValidatorError.Error -> RpcResponse.Failure(ErrorResult.Rpc(error = decoded.error))
        }
    }
  }
}
