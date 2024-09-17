package com.cornerstone.actionitems.screens.onboarding


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.cornerstone.actionitems.navigation.oboarding.login.LoginScreenComponent
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.cornerstone.actionitems.composables.CenteredColumn
import com.cornerstone.actionitems.composables.HeadingTextField
import com.cornerstone.actionitems.navigation.oboarding.OnboardingEvent
import com.cornerstone.actionitems.navigation.oboarding.welcome.WelcomeScreenEvent


@Composable
fun LoginScreen(component: LoginScreenComponent) {

    val email by component.email.subscribeAsState()
    val password by component.password.subscribeAsState()

    CenteredColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        HeadingTextField("Login To Action Items")

        OutlinedTextField(
            label = { Text("Email") },
            value = email,
            onValueChange = { component.onEvent(OnboardingEvent.UpdateEmail(it)) })
        OutlinedTextField(
            label = { Text("Password") },
            value = password,
            onValueChange = { component.onEvent(OnboardingEvent.UpdatePassword(it)) })

        Button(onClick = {
            component.onEvent(OnboardingEvent.ClickLogin)
        }) {
            Text("Login")
        }
        TextButton(onClick = { component.onEvent(OnboardingEvent.GoToRegister) }) {
            Text("New to Action Items? Register here")
        }
    }
}



