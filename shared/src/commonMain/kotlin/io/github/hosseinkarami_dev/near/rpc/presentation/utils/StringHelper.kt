package io.github.hosseinkarami_dev.near.rpc.presentation.utils

object StringHelper {

    fun String.formatLabel(): String {
        return this.split('_').joinToString(" ") { word ->
            word.replaceFirstChar { if (it.isLowerCase()) it.uppercase() else it.toString() }
        }
    }
}