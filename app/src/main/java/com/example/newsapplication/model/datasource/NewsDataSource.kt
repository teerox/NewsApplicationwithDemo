package com.example.newsapplication.model.datasource

interface NewsDataSource<T> {

    suspend fun getAllNews(): List<T>
}