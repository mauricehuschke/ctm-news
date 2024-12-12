package de.chrisbecker386.ctmnewsandroidnative.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.chrisbecker386.ctmnewsandroidnative.R
import de.chrisbecker386.ctmnewsandroidnative.data.model.dummyNewsItems

@Composable
fun DetailsScreen(detailsType: Int) {
    val newsItem = dummyNewsItems[detailsType]
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(8.dp))
        // Header with title
        Text(text = newsItem.title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        // Header image

        Image(
            painter = painterResource(id = newsItem.imageRes), // Replace with actual image loading
            contentDescription = newsItem.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Subtitle
            Text(
                text = newsItem.description.take(20),
                style = MaterialTheme.typography.titleMedium,
            ) // Replace with actual subtitle
            Spacer(modifier = Modifier.height(8.dp))

            // Detailed news content (text and images)
            Text(
                text = newsItem.description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(detailsType = 1)
}
