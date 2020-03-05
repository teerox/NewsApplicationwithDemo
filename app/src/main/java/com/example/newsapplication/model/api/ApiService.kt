package com.example.newsapplication.model.api

import com.example.newsapplication.model.Welcome
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    fun getAllNewsAsync(@Query("api-key") api:String = RetrofitBuilder.KEY): Deferred<Welcome>
}
