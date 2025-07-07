package com.pulseshift.greensmtaani

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pulseshift.greensmtaani.ui.theme.Nunito

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            MtaaniWelcomeSplashScreen(navController)
        }
        composable("onboarding1") {
            OnboardingScreen1(navController)
        }
        composable("onboarding2") {
            OnboardingScreen2(navController)
        }
        composable("onboarding3") {
            OnboardingScreen3(navController)
        }
        composable("auth") {
            AuthScreen(navController)
        }
        composable("signup") {
            MtaaniSignUpScreen(navController)
        }
        composable("signin") {
            Text(
                text = "Sign In Screen (To Be Implemented)",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                fontFamily = Nunito,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}