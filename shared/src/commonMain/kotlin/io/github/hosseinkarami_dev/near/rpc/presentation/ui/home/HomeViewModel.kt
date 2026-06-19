package io.github.hosseinkarami_dev.near.rpc.presentation.ui.home

import androidx.lifecycle.ViewModel
import near_jsonrpc_client.shared.generated.resources.Res
import near_jsonrpc_client.shared.generated.resources.block
import near_jsonrpc_client.shared.generated.resources.block_desc
import near_jsonrpc_client.shared.generated.resources.block_effects
import near_jsonrpc_client.shared.generated.resources.block_effects_desc
import near_jsonrpc_client.shared.generated.resources.chunk
import near_jsonrpc_client.shared.generated.resources.chunk_desc
import near_jsonrpc_client.shared.generated.resources.gas_price
import near_jsonrpc_client.shared.generated.resources.gas_price_desc
import near_jsonrpc_client.shared.generated.resources.health
import near_jsonrpc_client.shared.generated.resources.health_desc
import near_jsonrpc_client.shared.generated.resources.net_status
import near_jsonrpc_client.shared.generated.resources.network_info
import near_jsonrpc_client.shared.generated.resources.network_info_desc
import near_jsonrpc_client.shared.generated.resources.next_light_client_block
import near_jsonrpc_client.shared.generated.resources.next_light_client_block_desc
import near_jsonrpc_client.shared.generated.resources.status_desc
import near_jsonrpc_client.shared.generated.resources.transaction
import near_jsonrpc_client.shared.generated.resources.transaction_desc
import near_jsonrpc_client.shared.generated.resources.tx_status
import near_jsonrpc_client.shared.generated.resources.tx_status_desc
import near_jsonrpc_client.shared.generated.resources.validators
import near_jsonrpc_client.shared.generated.resources.validators_desc
import near_jsonrpc_client.shared.generated.resources.view_account
import near_jsonrpc_client.shared.generated.resources.view_account_desc
import org.jetbrains.compose.resources.StringResource

data class EndpointItem(val name: StringResource, val description: StringResource)

class HomeViewModel : ViewModel() {
    val endpoints = listOf(
        EndpointItem(
            Res.string.net_status,
            Res.string.status_desc
        ),
        EndpointItem(
            Res.string.transaction,
            Res.string.transaction_desc
        ),
        EndpointItem(
            Res.string.view_account,
            Res.string.view_account_desc
        ),
        EndpointItem(
            Res.string.tx_status,
            Res.string.tx_status_desc
        ),
        EndpointItem(
            Res.string.health,
            Res.string.health_desc
        ),
        EndpointItem(
            Res.string.network_info,
            Res.string.network_info_desc
        ),
        EndpointItem(
            Res.string.block,
            Res.string.block_desc
        ),
        EndpointItem(
            Res.string.block_effects,
            Res.string.block_effects_desc
        ),
        EndpointItem(
            Res.string.chunk,
            Res.string.chunk_desc
        ),
        EndpointItem(
            Res.string.validators,
            Res.string.validators_desc
        ),
        EndpointItem(
            Res.string.gas_price,
            Res.string.gas_price_desc
        ),
        EndpointItem(
            Res.string.next_light_client_block,
            Res.string.next_light_client_block_desc
        ),
    )
}
