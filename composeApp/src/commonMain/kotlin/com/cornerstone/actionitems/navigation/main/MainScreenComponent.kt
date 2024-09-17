package com.cornerstone.actionitems.navigation.main

import com.arkivanov.decompose.ComponentContext

class MainScreenComponent(
    val text: String,
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
) : ComponentContext by componentContext {

    fun goBack(){
        onGoBack()
    }
}