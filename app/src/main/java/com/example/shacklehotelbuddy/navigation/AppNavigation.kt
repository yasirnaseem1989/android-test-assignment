package com.example.shacklehotelbuddy.navigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home")
    object Search: Screen(route = "search")
}
