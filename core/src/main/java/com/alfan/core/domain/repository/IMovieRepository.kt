package com.alfan.core.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.alfan.core.data.source.local.entity.FavoriteMovie
import com.alfan.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton


interface IMovieRepository {
    fun removeFromFavorite(id: String)
    fun checkMovie(id: String) : Int
    fun getNowPlayingMovies() : LiveData<PagingData<Movie>>
    fun getSearchMovies(query: String) : LiveData<PagingData<Movie>>
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun addToFavorite(favoriteMovie: Movie)

}