package io.github.hosseinkarami_dev.near.rpc.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Route
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.StringHelper.formatLabel
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UiText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import near_jsonrpc_client.shared.generated.resources.Res
import near_jsonrpc_client.shared.generated.resources.rpc_endpoints
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavController,
) {
    LazyColumn {
        item {
            Row(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = UiText.ResourceString(Res.string.rpc_endpoints).asString(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(MaterialTheme.colorScheme.outlineVariant)
                )
            }
        }
        items(homeViewModel.endpoints) { endpoint ->
            val endpointNameString = UiText.ResourceString(endpoint.name).asString()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                onClick = {
                    CoroutineScope(Dispatchers.Main).launch {
                        navController.navigate(
                            Route.Request.createRoute(
                                endpointNameString,
                                UiText.ResourceString(endpoint.description).asStringAsync()
                            )
                        )
                    }
                },
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                ListItem(
                    headlineContent = {
                        Text(
                            text = endpointNameString.formatLabel(),
                            fontWeight = FontWeight.Bold
                        )
                    },
                    supportingContent = {
                        Text(
                            UiText.ResourceString(endpoint.description).asString()
                        )
                    },
                    leadingContent = {
                        Icon(
                            Icons.Outlined.Code,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}
