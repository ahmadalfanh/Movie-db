package com.alfan.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alfan.core.data.source.local.entity.FavoriteMovie

@Database(
    entities = [FavoriteMovie::class],
    version = 1
)
abstract class FavoriteMovieDatabase : RoomDatabase(){
    abstract fun getFavoriteMovieDao(): FavoriteMovieDao
}