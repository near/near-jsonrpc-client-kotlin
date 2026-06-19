package io.github.hosseinkarami_dev.near.rpc.di

import io.github.hosseinkarami_dev.near.rpc.data.repositories.UserPreferencesRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val iosModule = module {
    single<UserPreferencesRepositoryImpl> { UserPreferencesRepositoryImpl() }

    single {
        HttpClient(Darwin) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
}