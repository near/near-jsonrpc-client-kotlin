package io.github.hosseinkarami_dev.near.rpc.di

import io.github.hosseinkarami_dev.near.rpc.MainViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.home.HomeViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.request.RequestViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val commonModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel() }

    viewModel { params ->
        RequestViewModel(
            get(),
            get(),
            params[0],
            params[1]
        )
    }
}