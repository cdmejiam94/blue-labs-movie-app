package com.challenge.bluelabsmovieapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class DBMovie(
    @PrimaryKey
    val movieId: Int,
    val originalTitle: String,
    val votes: Double?,
    val overview: String,
)