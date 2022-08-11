package com.challenge.bluelabsmovieapp.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.challenge.bluelabsmovieapp.model.DBMovie

@Database(entities = [DBMovie::class], version = 6)
abstract class MoviesDataBase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: MoviesDataBase? = null

        @Synchronized
        fun getInstance(context: Context): MoviesDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDataBase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}