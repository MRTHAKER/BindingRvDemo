package com.recyclerviewDemo.model

data class Articles(
    val title: String,
    val urlToImage: String,
    val description: String,
    var isChecked: Boolean = false
)
data class News(val category: List<NewsCategory>)

data class NewsCategory(var name: String, val list: List<Articles>)

