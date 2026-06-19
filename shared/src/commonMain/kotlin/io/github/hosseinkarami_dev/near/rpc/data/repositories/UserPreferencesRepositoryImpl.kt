package io.github.hosseinkarami_dev.near.rpc.data.repositories

import io.github.hosseinkarami_dev.near.rpc.domain.UserPreferencesRepository
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Network
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UserPreferences
import kotlinx.coroutines.flow.Flow

expect class UserPreferencesRepositoryImpl: UserPreferencesRepository {
    override val userPreferencesFlow: Flow<UserPreferences>
    override suspend fun updateThemeMode(themeMode: ThemeMode)
    override suspend fun updateDynamicColor(dynamicColor: Boolean)
    override suspend fun updateNetwork(network: Network)

}