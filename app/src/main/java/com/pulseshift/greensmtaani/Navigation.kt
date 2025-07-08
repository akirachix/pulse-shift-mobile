
package com.pulseshift.greensmtaani

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "signin"
    ) {
        composable("signin") {
            SignInScreen2(
                onForgotPassword = { navController.navigate("forgot_password") },
                onSignIn = { },
                onSignUp = { }
            )
        }
        composable("forgot_password") {
            ForgotPasswordScreen2(
                onSendOtp = { navController.navigate("enter_otp") }
            )
        }
        composable("enter_otp") {
            EnterOtpScreen(
                onVerifyClick = { navController.navigate("reset_password") },
                onResendClick = { }
            )
        }
        composable("reset_password") {
            ResetPasswordScreen2(
                onChangePassword = { navController.navigate("recovery_success") }
            )
        }
        composable("recovery_success") {
            RecoverySuccessScreen2(
                onSignInAgain = {
                    navController.popBackStack("signin", inclusive = false)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme(colorScheme = GreensMtaaniColorScheme) {
        AppNavigation()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignIn() {
    SignInScreen2(
        onForgotPassword = {},
        onSignIn = {},
        onSignUp = {}
    )
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun EnterOtpScreenPreview() {
    EnterOtpScreen(
        onVerifyClick = {},
        onResendClick = {}
    )
}