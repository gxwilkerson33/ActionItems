package com.cornerstone.actionitems.navigation.oboarding.welcome

sealed interface WelcomeScreenEvent {
    data object Register: WelcomeScreenEvent
    data object Login: WelcomeScreenEvent
}