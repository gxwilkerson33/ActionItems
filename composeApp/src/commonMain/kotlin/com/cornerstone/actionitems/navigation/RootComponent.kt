package com.cornerstone.actionitems.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushToFront
import com.cornerstone.actionitems.navigation.main.MainScreenComponent
import com.cornerstone.actionitems.navigation.oboarding.login.LoginScreenComponent
import com.cornerstone.actionitems.navigation.oboarding.register.RegisterComponent
import com.cornerstone.actionitems.navigation.oboarding.welcome.WelcomeScreenComponent
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.WelcomeScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.LoginScreen -> Child.LoginScreen(
                LoginScreenComponent(
                    componentContext = context,
                    onNavigateToMain = { text ->
                        navigation.pushToFront(Configuration.MainScreen(text))
                    }, onNavigateToRegister = {
                        navigation.pushToFront(Configuration.RegisterScreen)
                    }
                )
            )

            is Configuration.MainScreen -> Child.MainScreen(
                MainScreenComponent(
                    config.text,
                    context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )

            Configuration.WelcomeScreen -> Child.WelcomeScreen(
                WelcomeScreenComponent(
                    context,
                    onRegisterClick = { navigation.pushToFront(Configuration.RegisterScreen) },
                    onLoginClick = { navigation.pushToFront(Configuration.LoginScreen) })
            )

            Configuration.RegisterScreen -> Child.RegisterScreen(
                RegisterComponent(context, goToMainScreen = { email ->
                    navigation.pushToFront(Configuration.MainScreen(email))
                }, goToLogin = { navigation.pushToFront(Configuration.LoginScreen) })
            )
        }
    }

    sealed class Child {
        data class LoginScreen(val component: LoginScreenComponent) : Child()
        data class MainScreen(val component: MainScreenComponent) : Child()
        data class WelcomeScreen(val component: WelcomeScreenComponent) : Child()
        data class RegisterScreen(val component: RegisterComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object LoginScreen : Configuration()

        @Serializable
        data class MainScreen(val text: String) : Configuration()

        @Serializable
        data object WelcomeScreen : Configuration()

        @Serializable
        data object RegisterScreen : Configuration()
    }
}