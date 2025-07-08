
package com.pulseshift.greensmtaani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val GreensMtaaniColorScheme = lightColorScheme(
    primary = Color(0xFF00A216),
    onPrimary = Color.White,
    background = Color.White,
    onBackground = Color(0xFFF68F21),
    surface = Color.White,
    onSurface = Color(0xFF00A216)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = GreensMtaaniColorScheme) {
                AppNavigation()
            }
        }
    }
}






