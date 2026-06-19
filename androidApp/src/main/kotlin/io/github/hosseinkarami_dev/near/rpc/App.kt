package io.github.hosseinkarami_dev.near.rpc

import android.app.Application
import io.github.hosseinkarami_dev.near.rpc.di.commonModule
import io.github.hosseinkarami_dev.near.rpc.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(commonModule, androidModule)
        }
    }
}