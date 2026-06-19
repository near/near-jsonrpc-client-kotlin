package io.github.hosseinkarami_dev.near.rpc.domain

import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UserPreferences
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Network
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    val userPreferencesFlow: Flow<UserPreferences>
    suspend fun updateThemeMode(themeMode: ThemeMode)
    suspend fun updateDynamicColor(dynamicColor: Boolean)
    suspend fun updateNetwork(network: Network)
}