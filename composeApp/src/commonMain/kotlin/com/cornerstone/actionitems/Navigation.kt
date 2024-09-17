package com.cornerstone.actionitems

import actionitems.composeapp.generated.resources.Res
import actionitems.composeapp.generated.resources.login
import actionitems.composeapp.generated.resources.main
import org.jetbrains.compose.resources.StringResource


enum class ActionItemsScreen(val title: StringResource) {
    Login(Res.string.login),
    Main(Res.string.main)
}