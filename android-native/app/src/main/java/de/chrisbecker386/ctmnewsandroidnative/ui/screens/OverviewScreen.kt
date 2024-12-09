package de.chrisbecker386.ctmnewsandroidnative.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import de.chrisbecker386.ctmnewsandroidnative.ui.navigation.DETAILS_ROUTE

@Composable
fun OverviewScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Button(onClick = { navController.navigate(DETAILS_ROUTE) }) {
        Text("View Details")
    }}
}