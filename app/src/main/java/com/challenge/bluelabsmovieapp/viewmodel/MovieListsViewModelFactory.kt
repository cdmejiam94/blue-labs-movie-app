package com.challenge.bluelabsmovieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.challenge.bluelabsmovieapp.controller.ApiController

class MovieListsViewModelFactory (
    private val apiController: ApiController
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListsViewModel(apiController) as T
    }
}