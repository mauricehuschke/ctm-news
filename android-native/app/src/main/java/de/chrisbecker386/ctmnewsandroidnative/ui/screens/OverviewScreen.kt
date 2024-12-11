package de.chrisbecker386.ctmnewsandroidnative.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.chrisbecker386.ctmnewsandroidnative.R
import de.chrisbecker386.ctmnewsandroidnative.data.model.NewsItem
import de.chrisbecker386.ctmnewsandroidnative.data.model.dummyNewsItems

@Composable
fun OverviewScreen(onNavigateToDetails: (Int) -> Unit = {}) {
    LazyColumn(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        val newsItems = dummyNewsItems
        items(newsItems.size) { index ->
            val newsItem = newsItems[index]
            NewsItemCard(newsItem = newsItem, index = index, { onNavigateToDetails(index) })
        }
    }
}

@Composable
fun NewsItemCard(
    newsItem: NewsItem,
    index: Int,
    onClick: () -> Unit,
) {
    val context = LocalContext.current

    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { onClick() },
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with actual image loading
                contentDescription = newsItem.title,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = newsItem.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = newsItem.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
