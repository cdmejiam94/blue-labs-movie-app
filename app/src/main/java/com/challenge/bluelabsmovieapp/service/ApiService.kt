package com.challenge.bluelabsmovieapp.service

import com.challenge.bluelabsmovieapp.service.response.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("now_playing?api_key=fb7146f0ea7129cd2c5a3a34aa4a9f87&language=es-MX&page=1&region=MX")
    fun getOnCinemas(): Call<MoviesResponse>

    @GET("top_rated?api_key=fb7146f0ea7129cd2c5a3a34aa4a9f87&language=es-MX&page=1&region=MX")
    fun getTopRated(): Call<MoviesResponse>
}