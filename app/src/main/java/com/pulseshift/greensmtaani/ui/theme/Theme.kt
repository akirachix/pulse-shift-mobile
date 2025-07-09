package com.pulseshift.greensmtaani.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val GreensMtaaniLightColorScheme = lightColorScheme(
    primary = Color(0xFF00A216),
    secondary = Color(0xFFF68F21),
    tertiary = Color(0xFF43A047),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val GreensMtaaniDarkColorScheme = darkColorScheme(
    primary = Color(0xFF00A216),
    secondary = Color(0xFFF68F21),
    tertiary = Color(0xFF43A047),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun GreensMtaaniTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> GreensMtaaniDarkColorScheme
        else -> GreensMtaaniLightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}