package de.chrisbecker386.ctmnewsandroidnative.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import de.chrisbecker386.ctmnewsandroidnative.R

@Composable
fun LoginScreen(onNavigateToOverview: () -> Unit = {}) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Image in the upper third
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your image
            contentDescription = "App Logo",
            modifier =
                Modifier
                    .size(100.dp) // Adjust size as needed
                    .weight(1f, fill = false), // Occupy upper third
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Text input fields
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Login and Register buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(onClick = { /* Handle Register action */ }) {
                Text("Register")
            }
            Button(onClick = { onNavigateToOverview() }) {
                Text("Login")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Forgot Password link
        val annotatedString =
            buildAnnotatedString {
                withStyle(
                    style =
                        SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline,
                        ),
                ) {
                    append("Forgot Password?")
                }
            }
        ClickableText(
            text = annotatedString,
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
                context.startActivity(intent)
            },
        )
    }
}
