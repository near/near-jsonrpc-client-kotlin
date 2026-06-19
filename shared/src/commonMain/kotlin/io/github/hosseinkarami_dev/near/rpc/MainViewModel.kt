package io.github.hosseinkarami_dev.near.rpc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.data.repositories.UserPreferencesRepositoryImpl
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Network
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UserPreferences
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val userPreferencesRepository: UserPreferencesRepositoryImpl) : ViewModel() {

    val uiState = userPreferencesRepository.userPreferencesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = UserPreferences(ThemeMode.SYSTEM, true, Network.MAINNET)
    )

    fun updateThemeMode(themeMode: ThemeMode) {
        viewModelScope.launch {
            userPreferencesRepository.updateThemeMode(themeMode)
        }
    }

    fun updateDynamicColor(dynamicColor: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.updateDynamicColor(dynamicColor)
        }
    }

    fun updateNetwork(network: Network) {
        viewModelScope.launch {
            userPreferencesRepository.updateNetwork(network)
        }
    }
}