package io.github.hosseinkarami_dev.near.rpc.data.repositories
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.domain.UserPreferencesRepository
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Network
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import platform.Foundation.NSUserDefaults
import platform.Foundation.setValue

actual class UserPreferencesRepositoryImpl : UserPreferencesRepository {

    private val userDefaults = NSUserDefaults.standardUserDefaults

    private val _userPreferencesFlow = MutableStateFlow(loadPreferences())
    actual override val userPreferencesFlow: Flow<UserPreferences> = _userPreferencesFlow.asStateFlow()

    private fun loadPreferences(): UserPreferences {
        return UserPreferences(
            themeMode = ThemeMode.valueOf(
                userDefaults.stringForKey("theme_mode") ?: ThemeMode.SYSTEM.name
            ),
            dynamicColor = userDefaults.objectForKey("dynamic_color") as? Boolean ?: true,
            network = Network.valueOf(
                userDefaults.stringForKey("network") ?: Network.MAINNET.name
            )
        )
    }

    private fun savePreferences(preferences: UserPreferences) {
        userDefaults.setValue(preferences.themeMode.name, forKey = "theme_mode")
        userDefaults.setValue(preferences.dynamicColor, forKey = "dynamic_color")
        userDefaults.setValue(preferences.network.name, forKey = "network")
        _userPreferencesFlow.update { preferences }
    }

    actual override suspend fun updateThemeMode(themeMode: ThemeMode) {
        val current = _userPreferencesFlow.value
        savePreferences(current.copy(themeMode = themeMode))
    }

    actual override suspend fun updateDynamicColor(dynamicColor: Boolean) {
        val current = _userPreferencesFlow.value
        savePreferences(current.copy(dynamicColor = dynamicColor))
    }

    actual override suspend fun updateNetwork(network: Network) {
        val current = _userPreferencesFlow.value
        savePreferences(current.copy(network = network))
    }
}