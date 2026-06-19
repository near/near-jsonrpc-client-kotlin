package io.github.hosseinkarami_dev.near.rpc.presentation.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.hosseinkarami_dev.near.rpc.MainViewModel
import io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.Network
import io.github.hosseinkarami_dev.near.rpc.presentation.utils.UiText
import io.github.hosseinkarami_dev.near.rpc.utils.isDynamicColorSupported
import near_jsonrpc_client.shared.generated.resources.Res
import near_jsonrpc_client.shared.generated.resources.app_settings
import near_jsonrpc_client.shared.generated.resources.done
import near_jsonrpc_client.shared.generated.resources.dynamic_color
import near_jsonrpc_client.shared.generated.resources.network
import near_jsonrpc_client.shared.generated.resources.app_theme
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDialog(onDismiss: () -> Unit, viewModel: MainViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = UiText.ResourceString(Res.string.app_settings).asString()) },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = UiText.ResourceString(Res.string.network).asString(),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
                Network.entries.forEach { network ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.updateNetwork(network) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = uiState.network == network,
                            onClick = { viewModel.updateNetwork(network) }
                        )
                        Text(
                            text = network.title,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

                Text(
                    text = UiText.ResourceString(Res.string.app_theme).asString(),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
                ThemeMode.entries.forEach { themeMode ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.updateThemeMode(themeMode) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = uiState.themeMode == themeMode,
                            onClick = { viewModel.updateThemeMode(themeMode) }
                        )
                        Text(
                            text = themeMode.name.lowercase().replaceFirstChar { it.uppercase() },
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                if (isDynamicColorSupported()) {
                    HorizontalDivider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.updateDynamicColor(!uiState.dynamicColor) },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = UiText.ResourceString(Res.string.dynamic_color).asString(),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Switch(
                            checked = uiState.dynamicColor,
                            onCheckedChange = { viewModel.updateDynamicColor(it) }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = UiText.ResourceString(Res.string.done).asString())
            }
        }
    )
}
