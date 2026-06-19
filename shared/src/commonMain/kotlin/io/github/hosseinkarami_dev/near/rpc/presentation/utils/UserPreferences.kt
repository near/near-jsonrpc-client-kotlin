package io.github.hosseinkarami_dev.near.rpc.presentation.utils

import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode

data class UserPreferences(
    val themeMode: ThemeMode,
    val dynamicColor: Boolean,
    val network: Network
)