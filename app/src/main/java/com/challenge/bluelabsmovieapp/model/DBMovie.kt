package com.challenge.bluelabsmovieapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
class DBMovie(posterPath: String?, title: String?, voteAverage: Double?, id: Int?) {
    @PrimaryKey
    val movieId: Int = 0
    val originalTitle: String = ""
    val votes: String = ""
    val overview: String = ""
}