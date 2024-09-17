package com.cornerstone.actionitems

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import actionitems.composeapp.generated.resources.Res
import actionitems.composeapp.generated.resources.compose_multiplatform
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.cornerstone.actionitems.navigation.RootComponent
import com.cornerstone.actionitems.screens.onboarding.LoginScreen
import com.cornerstone.actionitems.screens.MainScreen
import com.cornerstone.actionitems.screens.onboarding.RegistrationScreen
import com.cornerstone.actionitems.screens.onboarding.WelcomeScreen
import com.cornerstone.actionitems.theme.ui.theme.AppTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
@Preview
fun App(root: RootComponent) {
    AppTheme {
        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when (val instance = child.instance) {
                is RootComponent.Child.LoginScreen -> LoginScreen(instance.component)
                is RootComponent.Child.MainScreen -> MainScreen(
                    instance.component.text,
                    instance.component
                )
                is RootComponent.Child.WelcomeScreen -> WelcomeScreen(instance.component)
                is RootComponent.Child.RegisterScreen -> RegistrationScreen(instance.component)
            }
        }
    }
}

@Composable
@Preview
fun App1() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Todays date is ${currentDate()}",
                modifier = Modifier.padding(20.dp),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

fun currentDate(): String {
    fun LocalDateTime.format() = toString().substringBefore('T')
    val now = Clock.System.now()
    val zone = TimeZone.currentSystemDefault()
    return now.toLocalDateTime(zone).format()
}