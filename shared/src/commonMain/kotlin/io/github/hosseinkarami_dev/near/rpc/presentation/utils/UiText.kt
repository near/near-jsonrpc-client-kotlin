package io.github.hosseinkarami_dev.near.rpc.presentation.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    
    data class ResourceString(
        val resource: StringResource,
        val args: List<Any> = emptyList()
    ) : UiText() {
        constructor(resource: StringResource, vararg args: Any) : this(resource, args.toList())
    }

    @Composable
    fun asString(): String = when (this) {
        is DynamicString -> value
        is ResourceString -> {
            if (args.isEmpty()) stringResource(resource)
            else stringResource(resource, *args.toTypedArray())
        }
    }

    suspend fun asStringAsync(): String = when (this) {
        is DynamicString -> value
        is ResourceString -> {
            if (args.isEmpty()) getString(resource)
            else getString(resource, *args.toTypedArray())
        }
    }
}

// Helper functions
fun uiText(resource: StringResource, vararg args: Any): UiText.ResourceString = 
    UiText.ResourceString(resource, *args)

fun uiText(value: String): UiText.DynamicString = 
    UiText.DynamicString(value)