package com.recyclerviewDemo

import com.recyclerviewDemo.model.ArticlesRes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "328ecc9252904a7789972700cc47f4be"

interface NewsInterface {
    @GET("v2/everything?apiKey=${API_KEY}")
    suspend fun getNews(@Query("q") category: String = "India"): ArticlesRes
}

object ArticlesService {
    val articlesInstance: NewsInterface

    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
        articlesInstance = retrofit.create(NewsInterface::class.java)
    }
}
