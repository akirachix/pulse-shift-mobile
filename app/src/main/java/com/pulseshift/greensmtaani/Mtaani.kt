package com.pulseshift.greensmtaani

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.pulseshift.greensmtaani.ui.theme.Nunito
import kotlinx.coroutines.delay

@Composable
fun MtaaniWelcomeSplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(4000)
        navController.navigate("onboarding1") {
            popUpTo("splash") { inclusive = true }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
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
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight()
                )

            }
        }
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .align(Alignment.BottomCenter)
        ) {
            val width = size.width
            val height = size.height
            drawPath(
                path = Path().apply {
                    moveTo(0f, height * 0.5f)
                    quadraticBezierTo(
                        width * 0.25f, height * 0.2f,
                        width * 0.4f, height * 0.4f
                    )
                    quadraticBezierTo(
                        width * 0.75f, height * 0.8f,
                        width, height * 0.4f
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
fun OnboardingScreen1(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(78.dp))
            Image(
                painter = painterResource(id = R.drawable.mtaani_register),
                contentDescription = "Greens Mtaani Logo",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(410.dp)
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Easily list your products, manage inventory, handle orders through our user-friendly interface",
                fontSize = 22.sp,
                fontFamily = Nunito,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                CircleIndicator(selected = true)
                Spacer(modifier = Modifier.width(12.dp))
                CircleIndicator(selected = false)
                Spacer(modifier = Modifier.width(12.dp))
                CircleIndicator(selected = false)
            }
        }
        BottomWave()
        Box(
            modifier = Modifier
                .padding(bottom = 130.dp, end = 35.dp)
                .align(Alignment.BottomEnd)
        ) {
            CircleButton { navController.navigate("onboarding2") }
        }
    }
}

@Composable
fun OnboardingScreen2(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 44.dp, start = 16.dp)
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(74.dp))
            Image(
                painter = painterResource(id = R.drawable.get_started),
                contentDescription = "Paper Bag",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(420.dp)
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Browse local vendors, discover fresh products, and place orders",
                fontSize = 22.sp,
                fontFamily = Nunito,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                CircleIndicator(selected = false)
                Spacer(modifier = Modifier.width(12.dp))
                CircleIndicator(selected = true)
                Spacer(modifier = Modifier.width(12.dp))
                CircleIndicator(selected = false)
            }
        }
        BottomWave()
        Box(
            modifier = Modifier
                .padding(bottom = 130.dp, end = 35.dp)
                .align(Alignment.BottomEnd)
        ) {
            CircleButton { navController.navigate("onboarding3") }
        }
    }
}

@Composable
fun OnboardingScreen3(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 44.dp, start = 16.dp)
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(78.dp))
            Image(
                painter = painterResource(id = R.drawable.mtaani_start),
                contentDescription = "Leafy Green",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(410.dp)
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "We're excited to have you join our platform. Enjoy a seamless experience with our services!",
                fontSize = 22.sp,
                fontFamily = Nunito,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(70.dp))
            Button(
                onClick = { navController.navigate("auth") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C23C)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Get Started",
                    fontFamily = Nunito,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun AuthScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 44.dp, start = 16.dp)
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(78.dp))
            Image(
                painter = painterResource(id = R.drawable.welcome_img),
                contentDescription = "People",
                modifier = Modifier
                    .fillMaxWidth(0.99f)
                    .height(590.dp)
            )
            OutlinedButton(
                onClick = { navController.navigate("signup") },
                border = BorderStroke(2.dp, Color(0xFF00C23C)),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF00C23C)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Sign Up as Mama Mboga",
                    fontFamily = Nunito,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(35.dp))
            Button(
                onClick = { navController.navigate("signup") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C23C)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Sign Up as Customer",
                    fontFamily = Nunito,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.weight(1f))
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(top = 44.dp, start = 16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            Image(
                painter = painterResource(id = R.drawable.mtaani_signup),
                contentDescription = "Sign Up Illustration",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Sign Up",
                fontSize = 32.sp,
                color = Color(0xFF4CAF50),
                fontWeight = FontWeight.Bold,
                fontFamily = Nunito,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name", fontFamily = Nunito, fontWeight = FontWeight.Medium) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                textStyle = TextStyle(fontFamily = Nunito, fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", fontFamily = Nunito, fontWeight = FontWeight.Medium) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = TextStyle(fontFamily = Nunito, fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", fontFamily = Nunito, fontWeight = FontWeight.Medium) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
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
                textStyle = TextStyle(fontFamily = Nunito, fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password", fontFamily = Nunito, fontWeight = FontWeight.Medium) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
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
                textStyle = TextStyle(fontFamily = Nunito, fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { /* TODO: Implement sign-up logic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A216)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account? ",
                    fontSize = 14.sp,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "SIGN IN",
                    fontSize = 14.sp,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF6F00),
                    modifier = Modifier.clickable { navController.navigate("signin") }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun CircleIndicator(selected: Boolean) {
    val color = if (selected) Color(0xFF00C23C) else Color(0xFFE0E0E0)
    Box(
        modifier = Modifier
            .size(12.dp)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
fun BottomWave() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .align(Alignment.BottomCenter)
        ) {
            val width = size.width
            val height = size.height
            drawPath(
                path = Path().apply {
                    moveTo(0f, height * 0.5f)
                    quadraticBezierTo(
                        width * 0.25f, height * 0.2f,
                        width * 0.4f, height * 0.4f
                    )
                    quadraticBezierTo(
                        width * 0.75f, height * 0.8f,
                        width, height * 0.4f
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
fun CircleButton(onClick: () -> Unit) {
    Surface(
        color = Color(0xFF00C23C),
        shape = CircleShape,
        shadowElevation = 8.dp,
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .clickable { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Next",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .rotate(180f)
            )
        }
    }
}