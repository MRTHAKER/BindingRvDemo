package com.recyclerviewDemo.model

data class Articles(
    val title: String,
    val urlToImage: String,
    val description: String,
    var isChecked: Boolean = false
)

data class News(
    val category: List<NewsCategory> = listOf(
        NewsCategory(
            "Entertainment",
            listOf(
                Articles(
                    "Entrainment Article 1 Title 1",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                    "Entrainment Article Description 1"
                ), Articles(
                    "Entrainment Article Title 2",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                    "Entrainment Article Description 2"
                ), Articles(
                    "Entrainment Article Title 3",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                    "Entrainment Article Description 3"
                )
            )
        ),
        NewsCategory(
            "Sports",
            listOf(
                Articles(
                    "Sports Article Title 1",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                    "Sports Article Description 1"
                ), Articles(
                    "Sports Article Title 2",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                    "Sports Article Description 2"
                ), Articles(
                    "Sports Article Title 3",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                    "Sports Article Description 3"
                )
            )
        ),
        NewsCategory(
            "Technology",
            listOf(
                Articles(
                    "Technology Article Title 1",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                    "Technology Article Description 1"
                ), Articles(
                    "Technology Article Title 2",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                    "Technology Article Description 2"
                ), Articles(
                    "Technology Article Title 3",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                    "Technology Article Description 3"
                )
            )
        ),
        NewsCategory(
            "Business",
            listOf(
                Articles(
                    "Business Article Title 1",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                    "Business Article Description 1"
                ), Articles(
                    "Business Article Title 2",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                    "Business Article Description 2"
                ), Articles(
                    "Business Article Title 3",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                    "Business Article Description 3"
                )
            )
        ),
        NewsCategory(
            "International",
            listOf(
                Articles(
                    "International Article Title 1",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                    "International Article Description 1"
                ), Articles(
                    "International Article Title 2",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                    "International Article Description 2"
                ), Articles(
                    "International Article Title 3",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                    "International Article Description 3"
                )
            )
        )
    )
)

data class NewsCategory(var name: String, val list: List<Articles>)

