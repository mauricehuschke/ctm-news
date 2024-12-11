package de.chrisbecker386.ctmnewsandroidnative

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.chrisbecker386.ctmnewsandroidnative.ui.components.CtmNewsTopBar
import de.chrisbecker386.ctmnewsandroidnative.ui.navigation.APP_SCREENS
import de.chrisbecker386.ctmnewsandroidnative.ui.navigation.NavigationGraph
import de.chrisbecker386.ctmnewsandroidnative.ui.navigation.OverviewScreen
import de.chrisbecker386.ctmnewsandroidnative.ui.theme.CtmNewsAndroidNativeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CtmNewsApp()
        }
    }
}

@Composable
fun CtmNewsApp() {
    CtmNewsAndroidNativeTheme {
        val tag = "CtmNewsApp"
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            APP_SCREENS.find {
                // route without args
                (it.route == currentDestination?.route) ||
                    (it.route == currentDestination?.route?.split("/")?.first()) ||
                    (it.route == currentDestination?.route?.split("?")?.first())
            } ?: OverviewScreen
        Scaffold(
            topBar = {
                CtmNewsTopBar(
                    title = currentScreen.title,
                    onBackClick = { navController.navigateUp() },
                )
            },
        ) { innerPadding ->
            NavigationGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}
