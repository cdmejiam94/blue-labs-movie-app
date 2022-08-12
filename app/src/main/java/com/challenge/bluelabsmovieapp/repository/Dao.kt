package com.challenge.bluelabsmovieapp.repository

import androidx.room.Dao
import androidx.room.Insert
import com.challenge.bluelabsmovieapp.model.DBMovie

@Dao
interface Dao {
    @Insert
    fun insertMovie(movie: DBMovie)
}