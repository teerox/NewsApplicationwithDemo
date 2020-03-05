package com.example.newsapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapplication.repository.NewsRepository

class ViewModelFactory(private val tasksRepository:NewsRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>) = (AllViewModel(tasksRepository) as T)
}