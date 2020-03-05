package com.example.newsapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapplication.model.Result
import com.example.newsapplication.repository.NewsRepository
import kotlinx.coroutines.runBlocking

class AllViewModel(private val newsRepository: NewsRepository):ViewModel(){
    val items: MutableLiveData<List<Result>> = MutableLiveData()

    init {
        getAllNews()
    }

    private fun getAllNews(){
        runBlocking {
            items.postValue(newsRepository.getMovies())
        }
    }


}