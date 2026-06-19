package io.github.hosseinkarami_dev.near.rpc.presentation.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.hosseinkarami_dev.near.rpc.MainViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.home.HomeViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.settings.SettingsDialog
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.BaseTheme
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Route
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.StringHelper.formatLabel
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UiText
import io.ktor.client.HttpClient
import near_jsonrpc_client.shared.generated.resources.Res
import near_jsonrpc_client.shared.generated.resources.back
import near_jsonrpc_client.shared.generated.resources.near_logo
import near_jsonrpc_client.shared.generated.resources.request
import org.jetbrains.compose.resources.painterResource

@Composable
fun App(
    homeViewModel: HomeViewModel,
    mainViewModel: MainViewModel,
) {

    val uiState by mainViewModel.uiState.collectAsState()
    var showSettingsDialog by remember { mutableStateOf(false) }

    BaseTheme(
        darkTheme = when (uiState.themeMode) {
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
            ThemeMode.SYSTEM -> isSystemInDarkTheme()
        },
        dynamicColor = uiState.dynamicColor,
    ) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val scrollBehavior =
            TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

        if (showSettingsDialog) {
            SettingsDialog(
                onDismiss = { showSettingsDialog = false },
                viewModel = mainViewModel
            )
        }

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                when (currentDestination?.route) {
                    Route.Home.path -> {
                        LargeTopAppBar(
                            title = {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        modifier = Modifier.height(80.dp),
                                        painter = painterResource(Res.drawable.near_logo),
                                        contentDescription = "NEAR Protocol",
                                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = { showSettingsDialog = true }) {
                                    Icon(
                                        imageVector = Icons.Outlined.Settings,
                                        contentDescription = "Settings"
                                    )
                                }
                            },
                            scrollBehavior = scrollBehavior
                        )
                    }

                    else -> {
                        if (currentDestination?.route?.startsWith(
                                Route.Request.path.substringBefore(
                                    "/"
                                )
                            ) == true
                        ) {
                            TopAppBar(
                                title = {
                                    val titleText =
                                        navBackStackEntry?.savedStateHandle?.get<String>("endpointName")?.let {
                                                UiText.DynamicString(
                                                    it
                                                )
                                            }
                                            ?: UiText.ResourceString(
                                                Res.string.request
                                            )
                                    Text(text = titleText.asString().formatLabel())
                                },
                                navigationIcon = {
                                    IconButton(onClick = { navController.navigateUp() }) {
                                        Icon(
                                            imageVector = Icons.Default.ArrowBack,
                                            contentDescription = UiText.ResourceString(
                                                Res.string.back
                                            )
                                                .asString()
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            }
        ) { contentPadding ->
            AppNavHost(
                homeViewModel = homeViewModel,
                navController = navController,
                modifier = Modifier.padding(contentPadding)
            )
        }
    }
}