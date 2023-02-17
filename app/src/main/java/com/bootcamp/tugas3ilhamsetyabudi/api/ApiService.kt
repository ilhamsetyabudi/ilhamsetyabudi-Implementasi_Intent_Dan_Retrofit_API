package com.bootcamp.tugas3ilhamsetyabudi.api

import com.bootcamp.tugas3ilhamsetyabudi.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<ResponseNews>
}
