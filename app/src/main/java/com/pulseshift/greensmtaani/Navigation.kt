package com.pulseshift.greensmtaani

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
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
        composable("signup/{userType}") { backStackEntry ->
            val userType = backStackEntry.arguments?.getString("userType") ?: "customer"
            MtaaniSignUpScreen(navController, userType)
        }
        composable("signin") {
            SignInScreen2(
                onForgotPassword = { navController.navigate("forgot_password") },
                onSignIn = { navController.navigate("home") { popUpTo("auth") { inclusive = true } } },
                onSignUp = { navController.navigate("signup/customer") },
                navController = navController
            )
        }
        composable("forgot_password") {
            ForgotPasswordScreen2(
                onSendOtp = { navController.navigate("enter_otp") },
                navController = navController
            )
        }
        composable("enter_otp") {
            EnterOtpScreen(
                onVerifyClick = { navController.navigate("reset_password") },
                onResendClick = { /* TODO: Implement resend OTP logic */ },
                navController = navController
            )
        }
        composable("reset_password") {
            resettingpassword2(navController = navController)
        }
        composable("recovery_success") {
            RecoverySuccessScreen2(navController = navController)
        }
        composable("home") {
            Text(
                text = "Welcome to Greens Mtaani!",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}