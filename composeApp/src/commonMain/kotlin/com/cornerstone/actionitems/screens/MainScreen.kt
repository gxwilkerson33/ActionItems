package com.cornerstone.actionitems.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cornerstone.actionitems.navigation.main.MainScreenComponent
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun MainScreen(text: String, component: MainScreenComponent) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Main Screen: $text")
        Button(onClick = {
            component.goBack()
        }) {
            Text("Go Back")
        }
    }

}
