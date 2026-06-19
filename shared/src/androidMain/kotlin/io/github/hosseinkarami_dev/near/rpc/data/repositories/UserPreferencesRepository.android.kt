package io.github.hosseinkarami_dev.near.rpc.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.domain.UserPreferencesRepository
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Network
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

actual class UserPreferencesRepositoryImpl(context: Context) : UserPreferencesRepository {

    private val dataStore = context.dataStore

    private object Keys {
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        val NETWORK = stringPreferencesKey("network")
    }

    actual override val userPreferencesFlow: Flow<UserPreferences> = dataStore.data.map { prefs ->
        UserPreferences(
            themeMode = ThemeMode.valueOf(
                prefs[Keys.THEME_MODE] ?: ThemeMode.SYSTEM.name
            ),
            dynamicColor = prefs[Keys.DYNAMIC_COLOR] ?: true,
            network = Network.valueOf(
                prefs[Keys.NETWORK] ?: Network.MAINNET.name
            )
        )
    }

    actual override suspend fun updateThemeMode(themeMode: ThemeMode) {
        dataStore.edit { prefs ->
            prefs[Keys.THEME_MODE] = themeMode.name
        }
    }

    actual override suspend fun updateDynamicColor(dynamicColor: Boolean) {
        dataStore.edit { prefs ->
            prefs[Keys.DYNAMIC_COLOR] = dynamicColor
        }
    }

    actual override suspend fun updateNetwork(network: Network) {
        dataStore.edit { prefs ->
            prefs[Keys.NETWORK] = network.name
        }
    }
}