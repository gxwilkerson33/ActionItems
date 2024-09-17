package com.cornerstone.actionitems.navigation.oboarding.register

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.cornerstone.actionitems.navigation.oboarding.OnboardingEvent

class RegisterComponent(
    componentContext: ComponentContext,
    private val goToLogin: () -> Unit,
    private val goToMainScreen: (email: String) -> Unit
) {
    private var _email = MutableValue("")
    val email: Value<String> = _email

    private var _password = MutableValue("")
    val password: Value<String> = _password

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.PerformRegistration -> {
                performRegistration(event.info)
                goToMainScreen(event.info.email)
            }

            OnboardingEvent.ReturnToLogin -> goToLogin()
            is OnboardingEvent.UpdateEmail -> {
                _email.value = event.email
            }

            is OnboardingEvent.UpdatePassword -> {
                _password.value = event.password
            }

            OnboardingEvent.ClickLogin,OnboardingEvent.GoToRegister -> {}
        }
    }

    private fun performRegistration(info: RegistrationInfo) {
//        TODO("Not yet implemented")
    }

}