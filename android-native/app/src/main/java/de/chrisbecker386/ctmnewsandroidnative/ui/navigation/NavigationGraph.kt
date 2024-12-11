package de.chrisbecker386.ctmnewsandroidnative.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.chrisbecker386.ctmnewsandroidnative.ui.screens.DetailsScreen
import de.chrisbecker386.ctmnewsandroidnative.ui.screens.LoginScreen
import de.chrisbecker386.ctmnewsandroidnative.ui.screens.OverviewScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = LoginScreen.route,
        modifier = modifier,
    ) {
        composable(LoginScreen.route) {
            LoginScreen(onNavigateToOverview = {
                navController.navigate(OverviewScreen.route)
            })
        }

        composable(OverviewScreen.route) {
            OverviewScreen(onNavigateToDetails = { detailsType ->
                navController.navigateToDetailsScreen(detailsType)
            })
        }

        composable(
            route = DetailsScreen.routeWithArgs,
            arguments = DetailsScreen.arguments,
        ) { backStackEntry ->
            val detailsType = backStackEntry.arguments?.getInt(DetailsScreen.detailsTypeArgs)
            if (detailsType != null) {
                DetailsScreen(detailsType)
            }
        }
    }
}

private fun NavHostController.navigateToDetailsScreen(detailsType: Int) {
    this.navigate("${DetailsScreen.route}/$detailsType")
}
