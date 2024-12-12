package de.chrisbecker386.ctmnewsandroidnative.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import de.chrisbecker386.ctmnewsandroidnative.data.model.NewsItem
import de.chrisbecker386.ctmnewsandroidnative.data.model.dummyNewsItems

@Composable
fun OverviewScreen(onNavigateToDetails: (Int) -> Unit = {}) {
    LazyColumn(
        modifier =
        Modifier.fillMaxSize()
    ) {
        val newsItems = dummyNewsItems
        items(newsItems.size) { index ->
            val newsItem = newsItems[index]
            NewsItemCard(newsItem = newsItem, index = index, { onNavigateToDetails(index) })
        }
    }
}

@Composable
fun NewsItemCard(newsItem: NewsItem, index: Int, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = newsItem.imageRes),
            contentDescription = "News Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp), // Adjust height as needed
            contentScale = ContentScale.Crop
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-16).dp)
            .padding(horizontal = 16.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp,
            focusedElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)) {
            Text(
                text = newsItem.title,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = newsItem.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3, // Limit to 3 lines
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
