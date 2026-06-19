package io.github.hosseinkarami_dev.near.rpc.presentation.utils

enum class Network(
    val url: String,
    val title: String
) {
    MAINNET("https://rpc.mainnet.near.org", "Mainnet"),
    TESTNET("https://rpc.testnet.near.org", "Testnet")
}
