package io.github.hosseinkarami_dev.near.rpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.home.HomeViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.main.App
import org.koin.android.ext.android.inject

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel: MainViewModel by inject()
        val homeViewModel: HomeViewModel by inject()

        setContent {
            App(
                mainViewModel = mainViewModel,
                homeViewModel = homeViewModel
            )
        }
    }
}