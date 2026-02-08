package io.github.hosseinkarami_dev.near.rpc.client

sealed class RpcUrls {
    data class Single(val url: String) : RpcUrls()
    data class Multiple(val urls: List<String>) : RpcUrls()
}