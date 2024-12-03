package com.sylviepractices.motivationalquotes.model

sealed class NavigationRoutes(val route: String) {

    data object Quote: NavigationRoutes("Quote")

}