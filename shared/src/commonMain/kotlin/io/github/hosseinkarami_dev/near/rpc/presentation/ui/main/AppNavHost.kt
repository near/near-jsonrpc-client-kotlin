package io.github.hosseinkarami_dev.near.rpc.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.home.HomeScreen
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.home.HomeViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.request.RequestScreen
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Route
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun AppNavHost(
    homeViewModel: HomeViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Home.path,
        modifier = modifier
    ) {
        composable(Route.Home.path) {
            HomeScreen(homeViewModel = homeViewModel, navController = navController)
        }
        composable(Route.Request.path) { backStackEntry ->
            val endpointName = backStackEntry.savedStateHandle.get<String>("endpointName") ?: ""
            val description = backStackEntry.savedStateHandle.get<String>("description") ?: ""
            RequestScreen(
                viewModel = koinViewModel {
                    parametersOf(
                        endpointName,
                        description
                    )
                })
        }
    }
}
