package com.recyclerviewDemo.model

import androidx.lifecycle.MutableLiveData

data class ArticlesRes(val totalResults: Int, val articles: List<Articles>)
data class Articles(
    val title: String, val urlToImage: String, val description: String
)


data class CandidateJobDetail(val candidateName: String, val jobs: List<Job>)
data class Job(val name: String, val previousJob: List<PreviousJob>)
data class PreviousJob(val jobName: String, val friendsAtJob: List<String>)

data class Listing(val first: MutableLiveData<List<StringData>>) {
    data class StringData(var title: String, val second: MutableLiveData<List<StringTwo>>) {
        data class StringTwo(var description: String)
    }
}

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
            "Entertainment",
            listOf(
                Articles(
                    "Entertainment Article Title 1",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo1.png",
                    "Entertainment Article Description 1"
                ), Articles(
                    "Entertainment Article Title 2",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo2.png",
                    "Entertainment Article Description 2"
                ), Articles(
                    "Entertainment Article Title 3",
                    "https://placeholder.com/wp-content/uploads/2018/10/placeholder.com-logo3.png",
                    "Entertainment Article Description 3"
                )
            )
        )
    )
)

data class NewsCategory(var name: String, val list: List<Articles>)

