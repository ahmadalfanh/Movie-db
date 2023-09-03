package com.alfan.core.data.source.local

import com.alfan.core.data.source.local.entity.FavoriteMovie
import com.alfan.core.data.source.local.room.FavoriteMovieDao
import com.alfan.core.domain.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource @Inject constructor(private val favoriteMovieDao: FavoriteMovieDao) {
    fun addToFavorite(movie: Movie) = CoroutineScope(Dispatchers.IO).launch {
        favoriteMovieDao.addToFavorite(
            FavoriteMovie(
                movie.id,
                movie.original_title,
                movie.overview,
                movie.poster_path
            )
        )
    }

    fun getFavoriteMovies(): Flow<List<FavoriteMovie>> = favoriteMovieDao.getFavoriteMovie()


    fun checkMovie(id: String) = favoriteMovieDao.checkMovie(id)

    fun removeFromFavorite(id: String) = CoroutineScope(Dispatchers.IO).launch {
        favoriteMovieDao.removeFromFavorite(id)
    }
}