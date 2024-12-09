package de.chrisbecker386.ctmnewsandroidnative.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.chrisbecker386.ctmnewsandroidnative.ui.screens.DetailsScreen
import de.chrisbecker386.ctmnewsandroidnative.ui.screens.LoginScreen
import de.chrisbecker386.ctmnewsandroidnative.ui.screens.OverviewScreen

// Define navigation routes
const val LOGIN_ROUTE = "login"
const val OVERVIEW_ROUTE = "overview"
const val DETAILS_ROUTE = "details"

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LOGIN_ROUTE) {
        composable(LOGIN_ROUTE) { LoginScreen(navController) }
        composable(OVERVIEW_ROUTE) { OverviewScreen(navController) }
        composable(DETAILS_ROUTE) { DetailsScreen() }
    }
}