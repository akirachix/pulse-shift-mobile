package com.pulseshift.greensmtaani

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.pulseshift.greensmtaani.ui.theme.Nunito
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.Path

@Composable
fun MtaaniWelcomeSplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(4000)
        navController.navigate(Screen.First.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mtaani_logo),
                    contentDescription = "Greens Mtaani Logo",
                    modifier = Modifier
                        .weight(1.5f)
                        .fillMaxHeight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Divider(
                    modifier = Modifier.height(145.dp)
                        .width(3.dp)
                        .background(Color(0xFF4CAF50))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "GREENS",
                        fontSize = 35.sp,
                        color = Color(0xFF4CAF50),
                        fontWeight = FontWeight.Bold,
                        fontFamily = Nunito
                    )
                    Text(
                        text = "MTAANI",
                        fontSize = 35.sp,
                        color = Color(0xFFFF6F00),
                        fontWeight = FontWeight.Bold,
                        fontFamily = Nunito
                    )
                }
            }
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.BottomCenter)
        ) {
            val width = size.width
            val height = size.height
            drawPath(
                path = Path().apply {
                    moveTo(0f, height * 0.5f)
                    quadraticBezierTo(
                        width * 0.25f, height * 0.2f,
                        width * 0.5f, height * 0.4f
                    )
                    quadraticBezierTo(
                        width * 0.75f, height * 0.6f,
                        width, height * 0.3f
                    )
                    lineTo(width, height)
                    lineTo(0f, height)
                    close()
                },
                color = Color(0xFF00A216)
            )
        }
    }
}

@Composable
fun MtaaniOnboardingFirstScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(5700)
        navController.navigate(Screen.Second.route) {
            popUpTo(Screen.First.route) { inclusive = true }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.welcome_img),
                contentDescription = "Intro Image",
                modifier = Modifier.fillMaxWidth().height(280.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                "We're happy to have you on our platform, where you can enjoy a convenient and seamless shopping experience!",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = Nunito,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.BottomCenter)
        ) {
            val width = size.width
            val height = size.height
            drawPath(
                path = Path().apply {
                    moveTo(0f, height * 0.5f)
                    quadraticBezierTo(
                        width * 0.25f, height * 0.2f,
                        width * 0.5f, height * 0.4f
                    )
                    quadraticBezierTo(
                        width * 0.75f, height * 0.6f,
                        width, height * 0.3f
                    )
                    lineTo(width, height)
                    lineTo(0f, height)
                    close()
                },
                color = Color(0xFF00A216)
            )
        }
    }
}

@Composable
fun MtaaniOnboardingSecondScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.get_started),
                contentDescription = "Produce Image",
                modifier = Modifier.fillMaxWidth().height(390.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                "Order fresh fruits and vegetables from local vendors.",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = Nunito
            )
            Spacer(modifier = Modifier.height(56.dp))
            Button(
                onClick = { navController.navigate("third") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A216), contentColor = Color.White),
                shape = RoundedCornerShape(30),
                modifier = Modifier.fillMaxWidth(0.6f).height(48.dp)
            ) {
                Text(
                    "Get Started",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, fontFamily = Nunito)
                )
            }
        }
    }
}

@Composable
fun MtaaniOnboardingThirdScreen(navController: NavController) {
    val green = Color(0xFF00A216)
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.TopStart).padding(16.dp)
        ) {
            Icon(painter = painterResource(R.drawable.outline_arrow_back_24), contentDescription = "Back")
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.mtaani_register),
                contentDescription = "Veggie Basket",
                modifier = Modifier.fillMaxWidth().height(360.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                "Get started with your fresh food journey!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = Nunito
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MtaaniHoverableStyledButton(
                    text = "Sign Up",
                    onClick = { navController.navigate("signup") },
                    modifier = Modifier
                        .weight(1f)
                        .height(45.dp),
                    green = green,
                    fontFamily = Nunito
                )
                Spacer(modifier = Modifier.width(16.dp))
                MtaaniHoverableStyledButton(
                    text = "Sign In",
                    onClick = { navController.navigate("signin") },
                    modifier = Modifier
                        .weight(1f)
                        .height(45.dp),
                    green = green,
                    fontFamily = Nunito
                )
            }
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "OR",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                fontFamily = Nunito
            )
            Spacer(modifier = Modifier.height(26.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Logo"
                )
                Text(
                    text = "Continue with Google",
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 15.dp),
                    fontFamily = Nunito
                )
            }
        }
    }
}

@Composable
fun MtaaniSignUpScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    val imageRes = painterResource(id = R.drawable.mtaani_signup)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray.copy(alpha = 0.1f))
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.TopStart).padding(16.dp)
        ) {
            Icon(painter = painterResource(R.drawable.outline_arrow_back_24), contentDescription = "Back")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imageRes,
                contentDescription = "Sign Up Illustration",
                modifier = Modifier
                    .size(280.dp)
                    .padding(top = 32.dp)
            )
            Text(
                text = "Sign up",
                fontSize = 38.sp,
                color = Color(0xFF4CAF50),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                fontFamily = Nunito
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name", fontFamily = Nunito) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(fontFamily = Nunito)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", fontFamily = Nunito) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = TextStyle(fontFamily = Nunito)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", fontFamily = Nunito) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                        )
                    }
                },
                textStyle = TextStyle(fontFamily = Nunito)
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password", fontFamily = Nunito) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                        Icon(
                            imageVector = if (confirmPasswordVisibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (confirmPasswordVisibility) "Hide password" else "Show password"
                        )
                    }
                },
                textStyle = TextStyle(fontFamily = Nunito)
            )

            Button(
                onClick = { /* Add sign-up logic here */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A216)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Sign up", color = Color.White, fontSize = 18.sp, fontFamily = Nunito)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Already have an account? ",
                    modifier = Modifier.padding(top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    fontFamily = Nunito
                )
                Text(
                    text = "SIGN IN",
                    modifier = Modifier.padding(top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF6F00),
                    fontFamily = Nunito
                )
            }
        }
    }
}

@Composable
fun MtaaniHoverableStyledButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    green: Color,
    fontFamily: FontFamily = Nunito
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) green else Color.White,
        label = "button-bg"
    )
    val contentColor = if (isPressed) Color.White else green
    OutlinedButton(
        onClick = onClick,
        interactionSource = interactionSource,
        shape = RoundedCornerShape(30),
        border = BorderStroke(2.dp, green),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        modifier = modifier
    ) {
        Text(
            text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamily
            )
        )
    }
}