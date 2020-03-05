package com.example.newsapplication.repository

import com.example.newsapplication.model.Result

interface NewsRepository {

    suspend fun getMovies(): List<Result>?
}