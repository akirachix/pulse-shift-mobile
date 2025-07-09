package com.pulseshift.greensmtaani

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
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
                .height(300.dp)
                .align(Alignment.BottomCenter),
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
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Image(
                painter = painterResource(id = R.drawable.mtaani_register),
                contentDescription = "Greens Mtaani Logo",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(410.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Easily list your products, manage inventory, handle orders through our user-friendly interface",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
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
                .padding(bottom = 155.dp, end = 35.dp)
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
            .background(MaterialTheme.colorScheme.background)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 44.dp, start = 16.dp)
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00A216)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Image(
                painter = painterResource(id = R.drawable.get_started),
                contentDescription = "Paper Bag",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(420.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Browse local vendors, discover fresh products, and place orders",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
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
                .padding(bottom = 155.dp, end = 35.dp)
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
            .background(MaterialTheme.colorScheme.background)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 44.dp, start = 16.dp)
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00A216)
            )
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
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(70.dp))
            Button(
                onClick = { navController.navigate("auth") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A216),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Get Started",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    ),
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
            .background(MaterialTheme.colorScheme.background)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 44.dp, start = 16.dp)
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00A216)
            )
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

            HoverableButton(
                onClick = { navController.navigate("signup/mama_mboga") },
                text = "Sign Up as Mama Mboga",
                defaultBackgroundColor = Color.White,
                pressedBackgroundColor = Color(0xFF00A216),
                defaultTextColor = Color(0xFF00A216),
                pressedTextColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            HoverableButton(
                onClick = { navController.navigate("signup/customer") },
                text = "Sign Up as Customer",
                defaultBackgroundColor = Color.White,
                pressedBackgroundColor = Color(0xFF00A216),
                defaultTextColor = Color(0xFF00A216),
                pressedTextColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account? ",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "SIGN IN",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF00A216),
                    modifier = Modifier.clickable { navController.navigate("signin") }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
@Composable
fun MtaaniSignUpScreen(navController: NavHostController, userType: String? = "customer") {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    var nameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    fun isValidEmail(input: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }

    fun isValidKenyanPhone(input: String): Boolean {
        return input.matches(Regex("^(?:\\+254|254|0)(7|1)\\d{8}$"))
    }

    fun isValidEmailOrPhone(input: String): Boolean {
        return isValidEmail(input) || isValidKenyanPhone(input)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .imePadding()
    ) {
        IconButton(
            onClick = {
                if (navController.previousBackStackEntry != null) {
                    navController.popBackStack()
                } else {
                    navController.navigate("auth") {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            },
            modifier = Modifier.padding(top = 44.dp, start = 16.dp)
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00A216)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = painterResource(id = R.drawable.mtaani_signup),
                contentDescription = "Sign Up Illustration",
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Sign Up${if (userType == "mama_mboga") " as Mama Mboga" else " as Customer"}",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF00A216),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                    nameError = null
                },
                label = { Text("Name", style = MaterialTheme.typography.labelMedium) },
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                textStyle = MaterialTheme.typography.bodyMedium,
                isError = nameError != null
            )
            if (nameError != null) {
                Text(
                    text = nameError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 16.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = null
                },
                label = { Text("Email/Phone", style = MaterialTheme.typography.labelMedium) },
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = MaterialTheme.typography.bodyMedium,
                isError = emailError != null
            )
            if (emailError != null) {
                Text(
                    text = emailError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 16.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = null
                },
                label = { Text("Password", style = MaterialTheme.typography.labelMedium) },
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (passwordVisibility) "Hide password" else "Show password",
                            tint = Color(0xFF00A216)
                        )
                    }
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                isError = passwordError != null
            )
            if (passwordError != null) {
                Text(
                    text = passwordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 16.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    confirmPasswordError = null
                },
                label = { Text("Confirm Password", style = MaterialTheme.typography.labelMedium) },
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                        Icon(
                            imageVector = if (confirmPasswordVisibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (confirmPasswordVisibility) "Hide password" else "Show password",
                            tint = Color(0xFF00A216)
                        )
                    }
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                isError = confirmPasswordError != null
            )
            if (confirmPasswordError != null) {
                Text(
                    text = confirmPasswordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 16.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    nameError = if (name.isBlank()) "Name is required" else null
                    emailError = when {
                        email.isBlank() -> "Email or phone is required"
                        !isValidEmailOrPhone(email) -> "Enter a valid email or Kenyan phone number"
                        else -> null
                    }
                    passwordError = when {
                        password.isBlank() -> "Password is required"
                        password.length < 6 -> "Password must be at least 6 characters"
                        else -> null
                    }
                    confirmPasswordError = when {
                        confirmPassword.isBlank() -> "Confirm password is required"
                        confirmPassword != password -> "Passwords do not match"
                        else -> null
                    }
                    if (nameError == null && emailError == null && passwordError == null && confirmPasswordError == null) {
                        navController.navigate("home") { popUpTo("auth") { inclusive = true } }
                    }
                },
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A216),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account? ",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "SIGN IN",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(0xFF00A216),
                    modifier = Modifier.clickable { navController.navigate("signin") }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
@Composable
fun HoverableButton(
    onClick: () -> Unit,
    text: String,
    defaultBackgroundColor: Color,
    pressedBackgroundColor: Color,
    defaultTextColor: Color,
    pressedTextColor: Color,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) pressedBackgroundColor else defaultBackgroundColor,
            contentColor = if (isPressed) pressedTextColor else defaultTextColor
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Color(0xFF00A216)),
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        )
    }
}
@Composable
fun SignInScreen2(
    onForgotPassword: () -> Unit,
    onSignIn: () -> Unit,
    onSignUp: () -> Unit,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    fun isValidEmail(input: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }

    fun isValidKenyanPhone(input: String): Boolean {
        return input.matches(Regex("^(?:\\+254|254|0)(7|1)\\d{8}$"))
    }

    fun isValidEmailOrPhone(input: String): Boolean {
        return isValidEmail(input) || isValidKenyanPhone(input)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.7f))
            .imePadding()
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(top = 44.dp, start = 16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00A216)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.signinimage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.65f
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(70.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = null
                },
                label = { Text("Email/Phone", style = MaterialTheme.typography.labelLarge) },
                textStyle = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(10.dp)),
                isError = emailError != null,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                    focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    cursorColor = MaterialTheme.colorScheme.onBackground,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    disabledContainerColor = MaterialTheme.colorScheme.background,
                    errorContainerColor = MaterialTheme.colorScheme.background
                ),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
            if (emailError != null) {
                Text(
                    text = emailError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(42.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = null
                },
                label = { Text("Password", style = MaterialTheme.typography.labelLarge) },
                isError = passwordError != null,
                textStyle = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(10.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                    focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    cursorColor = MaterialTheme.colorScheme.onBackground,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    disabledContainerColor = MaterialTheme.colorScheme.background,
                    errorContainerColor = MaterialTheme.colorScheme.background
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(28.dp),
                            tint = Color(0xFF00A216) // Changed to green
                        )
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
            if (passwordError != null) {
                Text(
                    text = passwordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                var rememberMe by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF00A216),
                            uncheckedColor = Color.Gray,
                            checkmarkColor = Color.White
                        )
                    )
                    Text(
                        text = "Remember Me",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(modifier = Modifier.width(70.dp))
                TextButton(onClick = onForgotPassword) {
                    Text(
                        text = "Forgot Password?",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFF00A216)
                    )
                }
            }
            Spacer(modifier = Modifier.height(48.dp))
            Button(
                onClick = {
                    emailError = when {
                        email.isBlank() -> "Email or phone is required"
                        !isValidEmailOrPhone(email) -> "Enter a valid email or Kenyan phone number"
                        else -> null
                    }
                    passwordError = when {
                        password.isBlank() -> "Password is required"
                        password.length < 6 -> "Password must be at least 6 characters"
                        else -> null
                    }
                    if (emailError == null && passwordError == null) {
                        onSignIn()
                    }
                },
                enabled = true,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(200.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A216),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Sign In",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Do not have an account?",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(onClick = onSignUp) {
                    Text(
                        text = "SIGN UP",
                        color = Color(0xFF00A216),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        ),
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}

@Composable
fun ForgotPasswordScreen2(onSendOtp: () -> Unit, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }

    fun isValidEmail(input: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }

    fun isValidKenyanPhone(input: String): Boolean {
        return input.matches(Regex("^(?:\\+254|254|0)(7|1)\\d{8}$"))
    }

    fun isValidEmailOrPhone(input: String): Boolean {
        return isValidEmail(input) || isValidKenyanPhone(input)
    }

    val isButtonEnabled = email.isNotBlank() && isValidEmailOrPhone(email)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(top = 44.dp, start = 16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00A216)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.forgotpasswordimage1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(1.00f)
                    .height(442.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(44.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Forgot Password",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = null
                    },
                    label = { Text("Enter Email/Phone", style = MaterialTheme.typography.labelLarge) },
                    isError = emailError != null,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                        focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                        cursorColor = MaterialTheme.colorScheme.onBackground,
                        focusedTextColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                    ),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .width(350.dp)
                        .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
            }
            if (emailError != null) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = emailError ?: "",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(44.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        emailError = when {
                            email.isBlank() -> "Email or phone is required"
                            !isValidEmailOrPhone(email) -> "Enter a valid email or Kenyan phone number"
                            else -> null
                        }
                        if (emailError == null) {
                            onSendOtp()
                        }
                    },
                    shape = RoundedCornerShape(12.dp),
                    enabled = isButtonEnabled,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF00A216),
                        contentColor = Color.White,
                        disabledContainerColor = Color(0xFF00A216).copy(alpha = 0.8f),
                        disabledContentColor = Color.White.copy(alpha = 0.8f)
                    ),
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp)
                ) {
                    Text(
                        text = "Send OTP",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun EnterOtpScreen(
    onVerifyClick: () -> Unit,
    onResendClick: () -> Unit,
    navController: NavController
) {
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }
    var otpError by remember { mutableStateOf<String?>(null) }
    val otp = otp1 + otp2 + otp3 + otp4
    val isOtpValid = otp.length == 4 && otp.all { it.isDigit() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(top = 44.dp, start = 16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF00A216)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.forgotpasswordimage1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(1.00f)
                    .height(442.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Enter OTP",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 25.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Enter the code sent to your email/phone.",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf(
                    Pair(otp1) { value: String -> otp1 = value },
                    Pair(otp2) { value: String -> otp2 = value },
                    Pair(otp3) { value: String -> otp3 = value },
                    Pair(otp4) { value: String -> otp4 = value }
                ).forEach { (value, onValueChange) ->
                    OutlinedTextField(
                        value = value,
                        onValueChange = {
                            if (it.length <= 1 && (it.isEmpty() || it.all(Char::isDigit))) {
                                onValueChange(it)
                                otpError = null
                            }
                        },
                        isError = otpError != null,
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                            focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                            unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                            cursorColor = MaterialTheme.colorScheme.onBackground,
                            focusedTextColor = MaterialTheme.colorScheme.onBackground,
                            unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                        ),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                        modifier = Modifier
                            .width(70.dp)
                            .height(64.dp)
                            .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(8.dp)),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        )
                    )
                }
            }
            if (otpError != null) {
                Text(
                    text = otpError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(34.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Didn’t receive an OTP?",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(6.dp))
                TextButton(onClick = onResendClick) {
                    Text(
                        text = "Resend OTP",
                        color = Color(0xFF00A216),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            otpError = if (!isOtpValid) "Please enter a valid 4-digit OTP" else null
                            if (isOtpValid) onVerifyClick()
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00A216),
                            contentColor = Color.White,
                            disabledContainerColor = Color(0xFF00A216).copy(alpha = 0.8f),
                            disabledContentColor = Color.White.copy(alpha = 0.8f)
                        ),
                        modifier = Modifier
                            .width(200.dp)
                            .height(48.dp),
                        enabled = isOtpValid
                    ) {
                        Text(
                            text = "Verify",
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun resettingpassword2(
    navController: NavController,
    onChangePassword: () -> Unit = {}
) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    val passwordsMatch = newPassword == confirmPassword
    val passwordsNotEmpty = newPassword.isNotBlank() && confirmPassword.isNotBlank()
    val isFormValid = passwordsMatch && passwordsNotEmpty && newPassword.length >= 6

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.forgotpasswordimage1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(1.00f)
                .height(442.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Reset Password",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF00A216),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                value = newPassword,
                onValueChange = {
                    newPassword = it
                    passwordError = null
                },
                label = { Text("New Password", style = MaterialTheme.typography.labelLarge) },
                isError = passwordError != null,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                    focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    cursorColor = MaterialTheme.colorScheme.onBackground,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                ),
                visualTransformation = if (newPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { newPasswordVisible = !newPasswordVisible }) {
                        Icon(
                            imageVector = if (newPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (newPasswordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(28.dp),
                            tint = Color(0xFF00A216)
                        )
                    }
                },
                modifier = Modifier
                    .width(350.dp)
                    .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }
        if (passwordError != null && (newPassword.isBlank() || newPassword.length < 6)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = passwordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    passwordError = null
                },
                label = { Text("Confirm Password", style = MaterialTheme.typography.labelLarge) },
                isError = passwordError != null,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                    focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                    cursorColor = MaterialTheme.colorScheme.onBackground,
                    focusedTextColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                ),
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Icon(
                            imageVector = if (confirmPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(28.dp),
                            tint = Color(0xFF00A216)
                        )
                    }
                },
                modifier = Modifier
                    .width(350.dp)
                    .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }
        if (passwordError != null) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = passwordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(38.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    passwordError = when {
                        newPassword.isBlank() || confirmPassword.isBlank() -> "Password cannot be empty"
                        newPassword.length < 6 -> "Password must be at least 6 characters"
                        !passwordsMatch -> "Passwords do not match"
                        else -> null
                    }
                    Log.d("FormValidation", "isFormValid: $isFormValid, passwordsMatch: $passwordsMatch, passwordsNotEmpty: $passwordsNotEmpty, newPassword.length: ${newPassword.length}")
                    Log.d("NavigationDebug", "Current route: ${navController.currentBackStackEntry?.destination?.route}")
                    if (isFormValid) {
                        onChangePassword()
                        try {
                            navController.navigate("recovery_success") {
                                popUpTo("reset_password") { inclusive = true }
                            }
                        } catch (e: Exception) {
                            Log.e("NavigationError", "Failed to navigate: ${e.message}")
                        }
                    }
                },
                enabled = isFormValid,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00A216),
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFF00A216).copy(alpha = 0.8f),
                    disabledContentColor = Color.White.copy(alpha = 0.8f)
                ),
                modifier = Modifier
                    .width(250.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = "Change Password",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                    color = Color.White
                )
            }
        }
    }
}
@Composable
fun RecoverySuccessScreen2(
    navController: NavController,
    onSignInAgain: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.lastimage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.7f))
        )
        Column(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = null,
                tint = Color(0xFF00A216),
                modifier = Modifier.size(96.dp)
            )
            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = "Congratulations",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color.White
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Your account has been successfully recovered.",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White.copy(alpha = 0.9f)
                ),
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center,
                letterSpacing = 1.5.sp
            )
            Spacer(modifier = Modifier.height(60.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        onSignInAgain()
                        navController.navigate("signin") {
                            popUpTo("auth") { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF00A216),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Sign In",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                        color = Color.White
                    )
                }
            }
        }
    }
}
@Composable
fun CircleIndicator(selected: Boolean) {
    val color = if (selected) Color(0xFF00A216) else Color(0xFFE0E0E0)
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
                .height(300.dp)
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
        color = Color(0xFF00A216),
        shape = CircleShape,
        shadowElevation = 8.dp,
        onClick = onClick,
        modifier = Modifier.size(60.dp)
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