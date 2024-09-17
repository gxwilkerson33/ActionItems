package com.cornerstone.actionitems.navigation.oboarding

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

open class OnboardingComponent(
    componentContext: ComponentContext,
    private val onNavigateToMain: (String) -> Unit
) : ComponentContext by componentContext {

    var _email = MutableValue("")
    val email: Value<String> = _email

    var _password = MutableValue("")
    val password: Value<String> = _password


}