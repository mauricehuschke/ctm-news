package de.chrisbecker386.ctmnewsandroidnative.data.model

import de.chrisbecker386.ctmnewsandroidnative.R


val dummyNewsItems: List<NewsItem>
    get() = listOf(
        NewsItem(
            title = "News Title 1",
            description = lorem,
            imageRes = R.drawable.unsplash_01, // Replace with actual image URLs
            newsUrl = "news_url_1",
        ),
        NewsItem(
            title = "News Title 2",
            description = lorem,
            imageRes = R.drawable.unsplash_02,
            newsUrl = "news_url_2",
        ),
        NewsItem(
            title = "News Title 3",
            description = lorem,
            imageRes = R.drawable.unsplash_03,
            newsUrl = "news_url_3",
        ),
        NewsItem(
            title = "News Title 4",
            description = lorem,
            imageRes = R.drawable.unsplash_04,
            newsUrl = "news_url_4",
        ),
        NewsItem(
            title = "News Title 5",
            description = lorem,
            imageRes = R.drawable.unsplash_01,
            newsUrl = "news_url_5",
        ),
        NewsItem(
            title = "News Title 6",
            description = lorem,
            imageRes =  R.drawable.unsplash_02,
            newsUrl = "news_url_6",
        ),
        NewsItem(
            title = "News Title 7",
            description = lorem,
            imageRes =  R.drawable.unsplash_03,
            newsUrl = "news_url_7",
        ),
        NewsItem(
            title = "News Title 8",
            description = lorem,
            imageRes =  R.drawable.unsplash_04,
            newsUrl = "news_url_8",
        ),
        NewsItem(
            title = "News Title 9",
            description = lorem,
            imageRes =  R.drawable.unsplash_01,
            newsUrl = "news_url_9",
        ),
        NewsItem(
            title = "News Title 10",
            description = lorem,
            imageRes =  R.drawable.unsplash_02,
            newsUrl = "news_url_10",
        ),
    )

const val lorem:String ="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
        "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At " +
        "vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea " +
        "takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur " +
        "sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna " +
        "aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. " +
        "Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum "