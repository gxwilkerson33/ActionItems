package com.cornerstone.actionitems.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cornerstone.actionitems.composables.HeadingTextField
import com.cornerstone.actionitems.composables.SubHeadingTextField
import com.cornerstone.actionitems.navigation.oboarding.welcome.WelcomeScreenComponent
import com.cornerstone.actionitems.navigation.oboarding.welcome.WelcomeScreenEvent

@Composable
fun WelcomeScreen(component: WelcomeScreenComponent) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeadingTextField("Welcome to Action Items!")
        SubHeadingTextField("Reclaim Your Day")
        Button(onClick = { component.onEvent(WelcomeScreenEvent.Login) }) {
            Text("Login")
        }
        TextButton(onClick = { component.onEvent(WelcomeScreenEvent.Register) }) {
            Text("New to Action Items? Register here")
        }
    }
}

