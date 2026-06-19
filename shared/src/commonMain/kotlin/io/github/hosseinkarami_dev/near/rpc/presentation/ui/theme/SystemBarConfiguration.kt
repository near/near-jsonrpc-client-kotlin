package io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme

import androidx.compose.runtime.Composable

@Composable
expect fun SystemBarConfiguration(
    darkTheme: Boolean,
    dynamicColor: Boolean = true
)