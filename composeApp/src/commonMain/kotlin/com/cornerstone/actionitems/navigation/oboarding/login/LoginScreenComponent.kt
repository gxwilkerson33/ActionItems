package com.cornerstone.actionitems.navigation.oboarding.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.cornerstone.actionitems.navigation.oboarding.OnboardingComponent
import com.cornerstone.actionitems.navigation.oboarding.register.RegistrationInfo
import com.cornerstone.actionitems.navigation.oboarding.OnboardingEvent

class LoginScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToMain: (String) -> Unit,
    private val onNavigateToRegister: () -> Unit
) : OnboardingComponent(
    componentContext, onNavigateToMain
) {

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.ClickLogin -> {
                performLogin(RegistrationInfo(email.value, password.value))
                onNavigateToMain(email.value)
            }

            is OnboardingEvent.UpdateEmail -> {
                _email.value = event.email
            }

            is OnboardingEvent.UpdatePassword -> {
                _password.value = event.password
            }

            is OnboardingEvent.PerformRegistration, OnboardingEvent.ReturnToLogin -> {}
            OnboardingEvent.GoToRegister -> onNavigateToRegister()
        }
    }

    private fun performLogin(info: RegistrationInfo) {
//        todo perform backend login process
    }
}