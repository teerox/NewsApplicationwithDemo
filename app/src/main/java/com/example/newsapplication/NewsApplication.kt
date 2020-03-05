package com.example.newsapplication

import android.app.Application
import com.example.newsapplication.repository.NewsRepository

class NewsApplication :Application(){
    val newsRepository:NewsRepository
    get() = ServiceLocator.provideNewsRepository()

    override fun onCreate() {
        super.onCreate()
    }

}