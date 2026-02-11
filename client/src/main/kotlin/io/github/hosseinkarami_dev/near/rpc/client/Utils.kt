package io.github.hosseinkarami_dev.near.rpc.client

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

object Utils {
    inline fun <reified T> RpcResponse<*>.getResultOrNull(): T? = (this as? RpcResponse.Success<*>)?.result as T?
    inline fun <reified E : ErrorResult> RpcResponse<*>.getErrorOrNull(): E? = (this as? RpcResponse.Failure)?.error as? E
}

internal suspend fun <Req, Wrapper, Res, Err> callRpc(
    httpClient: HttpClient,
    baseUrl: String,
    request: Req,
    requestSerializer: KSerializer<Req>,
    responseSerializer: KSerializer<Wrapper>,
    errorSerializer: KSerializer<Err>,
    mapResponse: Function1<Wrapper, RpcResponse<Res>>,
): RpcResponse<Res> {
    val json = Json { ignoreUnknownKeys = true }

    try {
        val httpResponse = httpClient.post(baseUrl) {
            contentType(ContentType.Application.Json)
            setBody(json.encodeToString(requestSerializer, request))
        }

        val status = httpResponse.status.value
        val respBody = httpResponse.bodyAsText()

        if (status in 500..599) {
            try {
                val root = json.parseToJsonElement(respBody).jsonObject
                if (root.containsKey("error")) {
                    val rpcErr = json.decodeFromString(errorSerializer, root["error"].toString())
                    return RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr))
                }
                val resultEl = root["result"]
                if (resultEl?.jsonObject?.containsKey("error") == true) {
                    val errJson = resultEl.jsonObject["error"].toString()
                    val rpcErr = runCatching { json.decodeFromString(errorSerializer, errJson) }.getOrNull()
                    return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                }
            } catch (_: Exception) { /* ignore parse error */ }
            return RpcResponse.Failure(ErrorResult.Http(status, respBody))
        }

        try {
            val decoded = json.decodeFromString(responseSerializer, respBody)
            return mapResponse(decoded)
        } catch (serEx: Exception) {
            try {
                val root = json.parseToJsonElement(respBody).jsonObject
                val resultEl = root["result"]
                if (resultEl?.jsonObject?.containsKey("error") == true) {
                    val errJson = resultEl.jsonObject["error"].toString()
                    val rpcErr = runCatching { json.decodeFromString(errorSerializer, errJson) }.getOrNull()
                    return if (rpcErr != null) RpcResponse.Failure(ErrorResult.Rpc(error = rpcErr)) else RpcResponse.Failure(ErrorResult.RpcRuntime(errJson))
                }
            } catch (_: Exception) { /* ignore parse error */ }
            return RpcResponse.Failure(ErrorResult.Deserialization(serEx, respBody))
        }
    } catch (e: Throwable) {
        val mapped = when (e) {
            is java.util.concurrent.CancellationException -> ErrorResult.Cancellation(e)
            is java.net.SocketTimeoutException, is io.ktor.client.plugins.HttpRequestTimeoutException -> ErrorResult.Timeout(e)
            is java.io.IOException -> ErrorResult.Network(e)
            else -> ErrorResult.Unknown(e.message ?: "Unknown", e)
        }
        return RpcResponse.Failure(mapped)
    }
}