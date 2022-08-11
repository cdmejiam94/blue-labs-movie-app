package com.challenge.bluelabsmovieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.bluelabsmovieapp.controller.ApiController
import com.challenge.bluelabsmovieapp.service.response.MoviesResponse

class MovieListsViewModel(
    val apiController: ApiController
) : ViewModel() {

    val topMoviesListData: MutableLiveData<MoviesResponse?> = apiController.topMoviesResponseMutableLiveData
    val onCinemasMoviesListData: MutableLiveData<MoviesResponse?> = apiController.onCinemasResponseMutableLiveData

    fun getTopMovies(){
        apiController.getTopMovies()
    }

    fun getOnCinemasMovies(){
        apiController.getOnCinemasMovies()
    }

    fun getTopMoviesLiveDataContent() : MoviesResponse?{
        return topMoviesListData.value
    }

    fun getOnCinemasLiveDataContent() : MoviesResponse?{
        return onCinemasMoviesListData.value
    }

}