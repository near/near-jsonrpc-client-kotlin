package io.github.hosseinkarami_dev.near.rpc.presentation

import androidx.compose.ui.window.ComposeUIViewController
import io.github.hosseinkarami_dev.near.rpc.MainViewModel
import io.github.hosseinkarami_dev.near.rpc.di.commonModule
import io.github.hosseinkarami_dev.near.rpc.di.iosModule
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.home.HomeViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.main.App
import org.koin.compose.koinInject
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform

fun MainViewController() = ComposeUIViewController {
    if (KoinPlatform.getKoinOrNull() == null) {
        startKoin {
            modules(
                commonModule, iosModule
            )
        }
    }

    val mainViewModel = koinInject<MainViewModel>()
    val homeViewModel = koinInject<HomeViewModel>()

    App(
        mainViewModel = mainViewModel,
        homeViewModel = homeViewModel
    )
}