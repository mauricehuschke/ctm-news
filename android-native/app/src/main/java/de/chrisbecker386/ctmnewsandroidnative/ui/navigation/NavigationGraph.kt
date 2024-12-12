package de.chrisbecker386.ctmnewsandroidnative.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
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
        composable(LoginScreen.route,  enterTransition = {
            return@composable fadeIn(tween(1000))
        }, exitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
            )
        }, popEnterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(700)
            )
        }) {
            LoginScreen(onNavigateToOverview = {
                navController.navigate(OverviewScreen.route)
            })
        }

        composable(OverviewScreen.route,  enterTransition = {
            return@composable fadeIn(tween(1000))
        }, exitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
            )
        }, popEnterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(700)
            )
        }) {
            OverviewScreen(onNavigateToDetails = { detailsType ->
                navController.navigateToDetailsScreen(detailsType)
            })
        }

        composable(
            route = DetailsScreen.routeWithArgs,
            arguments = DetailsScreen.arguments,
            enterTransition = {
                return@composable fadeIn(tween(1000))
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
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
