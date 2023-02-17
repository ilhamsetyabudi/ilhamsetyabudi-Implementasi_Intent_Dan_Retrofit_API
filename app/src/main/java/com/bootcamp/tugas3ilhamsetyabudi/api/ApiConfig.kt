package com.bootcamp.tugas3ilhamsetyabudi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    private const val baseurl ="https://newsapi.org/v2/"

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService():ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}