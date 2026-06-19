package io.github.hosseinkarami_dev.near.rpc.utils

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.ChecksSdkIntAtLeast
import org.koin.java.KoinJavaComponent

actual fun isAndroid() = true
actual fun isIos() = false


actual fun showPlatformMessage(message: String, cancelMessage: String) {
    val context: Context = KoinJavaComponent.get(Context::class.java)
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
actual fun isDynamicColorSupported() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S