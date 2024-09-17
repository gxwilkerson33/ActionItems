package com.cornerstone.actionitems

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoginScreen(navController: NavController) {
    Column {
        Text("Login Screen")
        Button(onClick = { loginAndNavigate(navController) }) {
            Text("Login")
        }
    }
}

fun loginAndNavigate(navController: NavController) {
    navController.navigate(ActionItemsScreen.Main.name)
}

