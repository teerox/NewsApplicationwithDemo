package com.example.newsapplication.repository

import com.example.newsapplication.model.Result
import com.example.newsapplication.model.datasource.RemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultNewsRepository (private var taskRemoteDataSource: RemoteDataSource, private var ioDispatcher: CoroutineDispatcher = Dispatchers.IO):NewsRepository{
    override suspend fun getMovies(): List<Result>? {
        return taskRemoteDataSource.getAllNews()
    }

}