package com.pulseshift.greensmtaani

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object First : Screen("first")
    object Second : Screen("second")
    object Third : Screen("third")
    object SignUp : Screen("signup")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { MtaaniWelcomeSplashScreen(navController) }
        composable(Screen.First.route) { MtaaniOnboardingFirstScreen(navController) }
        composable(Screen.Second.route) { MtaaniOnboardingSecondScreen(navController) }
        composable(Screen.Third.route) { MtaaniOnboardingThirdScreen(navController) }
        composable(Screen.SignUp.route) { MtaaniSignUpScreen(navController) }
    }
}
