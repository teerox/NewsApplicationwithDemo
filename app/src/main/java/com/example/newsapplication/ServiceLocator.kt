package com.example.newsapplication

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.example.newsapplication.model.datasource.RemoteDataSource
import com.example.newsapplication.repository.DefaultNewsRepository
import com.example.newsapplication.repository.NewsRepository

object ServiceLocator {

    @Volatile
    var newsRepository:NewsRepository? =null


    fun provideNewsRepository():NewsRepository{
        synchronized(this){
            return newsRepository?: createNewsRepository()
        }
    }

    private fun createNewsRepository():NewsRepository{
        val newRepository =DefaultNewsRepository(RemoteDataSource())
        newsRepository = newRepository
        return newRepository
    }
}