package com.challenge.bluelabsmovieapp.repository

import com.challenge.bluelabsmovieapp.model.DBMovie

class Repository(private val movieDao: Dao) {

    fun insertMovie(movie: DBMovie) {
        movieDao.insertMovie(movie)
    }

}