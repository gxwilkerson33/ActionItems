package com.cornerstone.actionitems.navigation.oboarding

import com.cornerstone.actionitems.navigation.oboarding.register.RegistrationInfo

sealed interface OnboardingEvent {
    data object ClickLogin : OnboardingEvent
    data class UpdateEmail(val email: String) : OnboardingEvent
    data class UpdatePassword(val password: String) : OnboardingEvent
    data object ReturnToLogin : OnboardingEvent
    data object GoToRegister: OnboardingEvent
    data class PerformRegistration(val info: RegistrationInfo) : OnboardingEvent
}