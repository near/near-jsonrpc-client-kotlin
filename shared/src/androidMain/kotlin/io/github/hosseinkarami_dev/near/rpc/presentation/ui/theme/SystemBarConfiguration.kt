package io.github.hosseinkarami_dev.near.rpc.presentation.ui.theme
import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
actual fun SystemBarConfiguration(
    darkTheme: Boolean,
    dynamicColor: Boolean
) {
    val context = LocalContext.current
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    EdgeToEdge(context, darkTheme,colorScheme)
}
@Composable
fun EdgeToEdge(
    context: Context,
    isDarkMode: Boolean,
    colorScheme: ColorScheme
) {
    val statusBarLight = Color.Transparent.toArgb()
    val statusBarDark = Color.Transparent.toArgb()
    val navigationBarLight = colorScheme.surfaceContainerLow.toArgb()
    val navigationBarDark = colorScheme.surfaceContainerLow.toArgb()

    DisposableEffect(isDarkMode) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    scrim = statusBarLight,
                    darkScrim = statusBarDark
                )
            } else {
                SystemBarStyle.dark(
                    scrim = statusBarDark
                )
            },
            navigationBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    scrim = navigationBarLight,
                    darkScrim = navigationBarDark
                )
            } else {
                SystemBarStyle.dark(
                    scrim = navigationBarDark
                )
            }
        )

        onDispose { }
    }
}