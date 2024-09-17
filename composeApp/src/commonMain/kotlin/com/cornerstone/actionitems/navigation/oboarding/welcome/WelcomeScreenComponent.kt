package com.cornerstone.actionitems.navigation.oboarding.welcome

import com.arkivanov.decompose.ComponentContext

class WelcomeScreenComponent(
    componentContext: ComponentContext,
    private val onRegisterClick: () -> Unit,
    private val onLoginClick: () -> Unit
) {



    fun onEvent(event: WelcomeScreenEvent) {
        when (event) {
            WelcomeScreenEvent.Login -> onLoginClick()
            WelcomeScreenEvent.Register -> onRegisterClick()
        }
    }

}