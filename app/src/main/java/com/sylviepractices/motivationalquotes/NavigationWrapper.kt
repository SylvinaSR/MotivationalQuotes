package com.sylviepractices.motivationalquotes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sylviepractices.motivationalquotes.model.NavigationRoutes
import com.sylviepractices.motivationalquotes.ui.quote.QuoteScreen

@Composable
fun NavigationWrapper(
    modifier: Modifier,
    navHostController: NavHostController
) {

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = NavigationRoutes.Quote.route
    ) {
        composable(NavigationRoutes.Quote.route){
            QuoteScreen()
        }
    }

}