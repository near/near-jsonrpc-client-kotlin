package io.github.hosseinkarami_dev.near.rpc.utils

expect fun isAndroid(): Boolean
expect fun isIos(): Boolean
expect fun showPlatformMessage(message: String, cancelMessage: String)

expect fun isDynamicColorSupported(): Boolean