package com.cornerstone.actionitems

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform