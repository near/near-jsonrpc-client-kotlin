package io.github.hosseinkarami_dev.near.rpc.presentation.utils

sealed class Route(val path: String) {
    object Home : Route("home")
    object Request : Route("request/{endpointName}/{description}") {
        fun createRoute(endpointName: String, description: String) = "request/$endpointName/$description"
    }
}
