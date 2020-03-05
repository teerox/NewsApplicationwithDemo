package com.example.newsapplication.model.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val BASE_URL = "https://content.guardianapis.com/"
     val KEY = "cf4f8f5d-9f48-473c-9bc7-cd0c68660616"
    private val httpClient = okhttp3.OkHttpClient()

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).client(httpClient).build()
    }

    fun provideMovieApi(): ApiService{
        return provideRetrofit().create(ApiService::class.java)
    }
}