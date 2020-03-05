package com.example.newsapplication.model.datasource

import com.example.newsapplication.model.Result
import com.example.newsapplication.model.api.ApiService
import com.example.newsapplication.model.api.RetrofitBuilder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Error

class RemoteDataSource internal constructor(private var ioDispatcher: CoroutineDispatcher = Dispatchers.IO):NewsDataSource<Result> {

    private val apiService = RetrofitBuilder.provideMovieApi()
    override suspend fun getAllNews(): List<Result> {
        var data = listOf<Result>()
        withContext(ioDispatcher){
            try {
                val news = apiService.getAllNewsAsync().await().response.results
                data = news
            }catch (e:Error){
                e.printStackTrace()
            }
        }
        return data
    }

}