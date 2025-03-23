package dev.sivaprasadnk.fitapp.api

import dev.sivaprasadnk.fitapp.constants.ApiConstants.BASE_URL
import dev.sivaprasadnk.fitapp.data.Blog
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val blogService = retrofit.create(ApiService::class.java)


interface ApiService {
    @GET("blogs/recent/{count}")
    suspend fun getRecentBlogs(@Path("count") count: Int): Response<List<Blog>>
}