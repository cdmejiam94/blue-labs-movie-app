package com.challenge.bluelabsmovieapp.controller

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.challenge.bluelabsmovieapp.service.ApiClient
import com.challenge.bluelabsmovieapp.service.response.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiController {
    val topMoviesResponseMutableLiveData: MutableLiveData<MoviesResponse?>
    val onCinemasResponseMutableLiveData: MutableLiveData<MoviesResponse?>
    val service = ApiClient().initRetrofit()

    constructor() {
        this.topMoviesResponseMutableLiveData = MutableLiveData()
        this.onCinemasResponseMutableLiveData = MutableLiveData()
    }

    fun getTopMovies(){
        service.getTopRated().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.isSuccessful && response.body() != null){
                    Log.i("Top Rated Data GET: "," Succes!! " + 200 + " " + response.body()?.results)
                } else {
                    Log.i("Top Rated Data GET: ", " Succes!! " + 100 + " Not Found!")
                }

                topMoviesResponseMutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                topMoviesResponseMutableLiveData.postValue(null)
                Log.i("Top Rated Data: ","GET: " + 404 + " " + t.stackTraceToString())
            }
        })
    }

    fun getOnCinemasMovies(){
        service.getOnCinemas().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                if (response.isSuccessful && response.body() != null){
                    Log.i("On Cinemas Data GET: "," Succes!! " + 200 + " " + response.body()?.results)
                } else {
                    Log.i("On Cinemas Data GET: ", " Succes!! " + 100 + " Not Found!")
                }

                onCinemasResponseMutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                onCinemasResponseMutableLiveData.postValue(null)
                Log.i("On Cinemas Data: ","GET: " + 404 + " " + t.stackTraceToString())
            }
        })
    }
}