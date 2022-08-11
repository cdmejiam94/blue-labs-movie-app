package com.challenge.bluelabsmovieapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.bluelabsmovieapp.controller.ApiController
import com.challenge.bluelabsmovieapp.model.DBMovie
import com.challenge.bluelabsmovieapp.repository.MoviesDataBase
import com.challenge.bluelabsmovieapp.repository.Repository
import com.challenge.bluelabsmovieapp.service.response.MoviesResponse

class MovieListsViewModel(
    val apiController: ApiController,
    val application: Application
) : ViewModel() {

    val topMoviesListData: MutableLiveData<MoviesResponse?> = apiController.topMoviesResponseMutableLiveData
    val onCinemasMoviesListData: MutableLiveData<MoviesResponse?> = apiController.onCinemasResponseMutableLiveData
    val movieDao = MoviesDataBase.getInstance(application).dao()
    val repository: Repository = Repository(movieDao)

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

    fun saveAllMovies(){
        for (movie in topMoviesListData.value!!.results){
            saveMovies(DBMovie(movie.poster_path,movie.title,movie.vote_average,movie.id))
        }
    }

    fun saveMovies(movie: DBMovie){
        repository.insertMovie(movie)
    }
}