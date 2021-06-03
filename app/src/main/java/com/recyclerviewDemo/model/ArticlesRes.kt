package com.recyclerviewDemo.model

data class ArticlesRes(val totalResults: Int, val articles: List<Articles>)
data class Articles(
    val title: String, val urlToImage: String, val description: String, val url: String,
    var article: List<Articles>, var isSelected: Boolean = false
)


data class CandidateJobDetail(val candidateName: String, val jobs: List<Job>)
data class Job(val name: String, val previousJob: List<PreviousJob>)
data class PreviousJob(val jobName: String, val friendsAtJob: List<String>)

data class Listing(val first: List<StringData>)

data class StringData(var title:String, val second: List<StringTwo>)

data class StringTwo(var description: String)