package de.chrisbecker386.ctmnewsandroidnative.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Screens {
    val route: String
    val title: String
    val icon: ImageVector?
}

object LoginScreen : Screens {
    override val route: String = "login_screen"
    override val title: String = "Login"
    override val icon: ImageVector? = null
}

object OverviewScreen : Screens {
    override val route: String = "overview_screen"
    override val title: String = "Overview"
    override val icon: ImageVector = Icons.Default.Home
}

object DetailsScreen : Screens {
    override val route: String = "details_screen"
    override val title: String = "Details"
    override val icon = Icons.Default.Info
    const val detailsTypeArgs = "details_type"
    val routeWithArgs = "$route/{$detailsTypeArgs}"
    val arguments =
        listOf(
            navArgument(detailsTypeArgs) {
                defaultValue = 0
                type = NavType.IntType
            },
        )
}

val APP_SCREENS = listOf(LoginScreen, OverviewScreen, DetailsScreen)
