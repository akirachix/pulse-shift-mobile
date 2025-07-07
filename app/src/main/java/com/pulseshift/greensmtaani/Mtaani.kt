package com.pulseshift.greensmtaani

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.pulseshift.greensmtaani.ui.theme.Nunito

@Composable
fun SignInScreen2(
    onForgotPassword: () -> Unit,
    onSignIn: () -> Unit,
    onSignUp: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    fun isValidEmail(input: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }
    val isFormValid = email.isNotBlank() && isValidEmail(email) &&
            password.isNotBlank() && password.length >= 4

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .imePadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.signinimage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.65f
        )
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sign In", fontSize = 36.sp,  fontFamily = Nunito, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(70.dp))
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = null
                },
                label = { Text("Email",fontFamily = Nunito,color = Color.Black, fontWeight = FontWeight.SemiBold) },
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(10.dp)),
                isError = emailError != null,
                colors = OutlinedTextFieldDefaults.colors(

                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White

                ),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)

            )
            if (emailError != null) {
                Text(
                    text = emailError ?: "",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(Modifier.height(42.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = null
                },
                label = { Text("Password",fontFamily = Nunito,color = Color.Black, fontWeight = FontWeight.SemiBold) },
                isError = passwordError != null,
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                modifier = Modifier
                    .width(350.dp)
                    .height(64.dp)
                    .clip(RoundedCornerShape(10.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorContainerColor = Color.White


                ),

                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) painterResource(id = R.drawable.view) else painterResource(id = R.drawable.hide)
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(painter = icon, contentDescription = null,modifier = Modifier.size(28.dp), tint = Color.Black)
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
            if (passwordError != null) {
                Text(
                    text = passwordError ?: "",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(Modifier.height(30.dp))
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
                            checkedColor = Color(0xFF43A047),
                            uncheckedColor = Color.Gray,
                            checkmarkColor = Color.White
                        )
                    )
                    Text("Remember Me", fontSize = 16.sp,  fontFamily = Nunito, fontWeight = FontWeight.Normal)
                }
                Spacer(modifier = Modifier.width(70.dp))
                TextButton(onClick = onForgotPassword) {
                    Text("Forgot Password?", fontSize = 16.sp,  fontFamily = Nunito, color = Color(0xFF000000),fontWeight = FontWeight.Normal)
                }
            }
            Spacer(Modifier.height(48.dp))
            Button(
                onClick = {
                    emailError = when {
                        email.isBlank() -> "Email is required"
                        !isValidEmail(email) -> "Enter a valid email"
                        else -> null
                    }
                    passwordError = when {
                        password.isBlank() -> "Password is required"
                        password.length < 4 -> "Password must be at least 4 characters"
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
                    .height(48.dp)
            )
            {
                Text("Sign In",   fontFamily = Nunito,fontSize = 20.sp,fontWeight = FontWeight.Normal)
            }
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Do not have an account?",  fontFamily = Nunito,fontSize = 16.sp)
                Spacer(Modifier.width(4.dp))
                TextButton(onClick = onSignUp) {
                    Text(
                        "SIGN UP",
                        color = Color(0xFFF68F21),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Nunito,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}

@Composable
fun ForgotPasswordScreen2(onSendOtp: () -> Unit) {
    var email by remember { mutableStateOf("") }
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    val isEmailValid = email.matches(emailPattern.toRegex())
    val isButtonEnabled = email.isNotBlank() && isEmailValid
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.forgotpasswordimage1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(1.00f)
                .height(442.dp),
            contentScale = ContentScale.Crop,

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
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontFamily = Nunito,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Enter Email",fontFamily = Nunito, fontWeight = FontWeight.SemiBold,  fontSize = 15.sp) },
                isError = email.isNotBlank() && !isEmailValid,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                modifier = Modifier
                    .width(350.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )}
        if (email.isNotBlank() && !isEmailValid) {
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Text(
                    "Please enter a valid email address",
                    color = Color.Red,
                    fontSize = 12.sp,
                    fontFamily = Nunito,
                )
            }}
        Spacer(modifier = Modifier.height(44.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(
                onClick = onSendOtp,
                shape = RoundedCornerShape(12.dp),
                enabled = isButtonEnabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White,
                    disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                    disabledContentColor = Color.White.copy(alpha = 0.8f)
                ),
                modifier = Modifier
                    .width(200.dp)
                    .height(48.dp),
            ) {
                Text(
                    text = "Send OTP",
                    fontSize = 20.sp,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )}
        }
    }
}


@Composable
fun EnterOtpScreen(
    onVerifyClick: () -> Unit,
    onResendClick: () -> Unit
) {
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }
    val otp = otp1 + otp2 + otp3 + otp4
    val isOtpValid = otp.length == 4
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
            contentScale = ContentScale.Crop,

            )
        Spacer(Modifier.height(2.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Enter OTP",
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Nunito,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 25.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Enter the code sent to your email.",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Nunito,
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(18.dp))
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
                        if (it.length <= 1 && it.all(Char::isDigit)) {
                            onValueChange(it)
                        }
                    },
                    isError = otp.isNotBlank() && !isOtpValid,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                    modifier = Modifier
                        .width(70.dp)
                        .height(64.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                )
            }
        }
        Spacer(Modifier.height(34.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Didn’t receive an OTP?", color = Color.Black, fontSize = 20.sp  ,fontWeight = FontWeight.Normal,
                fontFamily = Nunito)
            Spacer(Modifier.height(6.dp))
            TextButton(onClick = onResendClick) {
                Text(
                    "Resend OTP",
                    color = Color(0xFFF68F21),
                    fontSize = 20.sp,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(Modifier.height(16.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Button(
                    onClick = onVerifyClick,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White,
                        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                        disabledContentColor = Color.White.copy(alpha = 0.8f)
                    ),
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp),
                    enabled = isOtpValid
                ) {
                    Text(
                        text = "Verify",
                        fontSize = 20.sp,
                        fontFamily = Nunito,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun ResetPasswordScreen2(onChangePassword: () -> Unit) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    val passwordsMatch = newPassword == confirmPassword
    val passwordsNotEmpty = newPassword.isNotBlank() && confirmPassword.isNotBlank()
    val isFormValid = passwordsMatch && passwordsNotEmpty
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.forgotpasswordimage1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(1.00f)
                .height(442.dp),
            contentScale = ContentScale.Crop,

            )
        Spacer(Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Reset Password",
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Nunito,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(28.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                label = { Text("New Password",fontWeight = FontWeight.SemiBold, fontSize = 20.sp,fontFamily = Nunito) },
                isError = newPassword.isBlank() && confirmPassword.isNotBlank(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                visualTransformation = if (newPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon =
                        if (newPasswordVisible) painterResource(id = R.drawable.view) else painterResource(
                            id = R.drawable.hide
                        )
                    IconButton(onClick = { newPasswordVisible = !newPasswordVisible }) {
                        Icon(
                            painter = icon,
                            contentDescription = if (newPasswordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                modifier = Modifier.width(350.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )
        }
        Spacer(Modifier.height(30.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password",fontWeight = FontWeight.SemiBold, fontSize = 20.sp,fontFamily = Nunito) },
                isError = confirmPassword.isNotEmpty() && !passwordsMatch,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon =
                        if (confirmPasswordVisible) painterResource(id = R.drawable.view) else painterResource(
                            id = R.drawable.hide
                        )
                    IconButton(onClick = {
                        confirmPasswordVisible = !confirmPasswordVisible
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                modifier = Modifier.width(350.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )
        }
        if (confirmPassword.isNotEmpty() && !passwordsMatch) {
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Text(
                    "Passwords do not match.",
                    color = Color.Red,
                    fontSize = 14.sp,
                    fontFamily = Nunito,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }}
        if (!passwordsNotEmpty && (newPassword.isNotEmpty() || confirmPassword.isNotEmpty())) {
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Text(
                    "Password cannot be empty.",
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }}
        Spacer(Modifier.height(38.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { if (isFormValid) onChangePassword() },
                enabled = isFormValid,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White,
                    disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                    disabledContentColor = Color.White.copy(alpha = 0.8f)
                ),
                modifier = Modifier
                    .width(250.dp)
                    .height(48.dp)
            )
            {
                Text("Change Password",fontWeight = FontWeight.SemiBold, fontSize = 20.sp,fontFamily = Nunito)
            }
        }
    }}

@Composable
fun RecoverySuccessScreen2(onSignInAgain: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.lastimage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.8f
        )
        Column(
            Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = null,
                tint = Color(0xFF00A216),
                modifier = Modifier.size(96.dp)
            )
            Spacer(Modifier.height(36.dp))
            Text(
                "Congratulations",
                fontSize = 45.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = Nunito,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(20.dp))
            Text(
                "Your account has been successfully recovered.",
                fontSize = 25.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center,
                fontFamily = Nunito,
                letterSpacing = 2.0.sp
            )
            Spacer(Modifier.height(60.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onSignInAgain,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(200.dp)
                        .height(48.dp)
                ) {
                    Text("Sign In", fontSize = 20.sp,fontFamily = Nunito,fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}



























