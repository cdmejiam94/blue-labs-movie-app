package com.challenge.bluelabsmovieapp.repository

import androidx.room.Insert
import com.challenge.bluelabsmovieapp.model.DBMovie

interface Dao {
    @Insert
    fun insertMovie(movie: DBMovie)
}