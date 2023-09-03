package com.alfan.core.data

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.alfan.core.data.source.local.LocalDataSource
import com.alfan.core.data.source.local.entity.FavoriteMovie
import com.alfan.core.data.source.network.RemoteDataSource
import com.alfan.core.domain.model.Movie
import com.alfan.core.domain.repository.IMovieRepository
import com.alfan.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : IMovieRepository {

    override fun removeFromFavorite(id: String) {
        localDataSource.removeFromFavorite(id)
    }

    override fun checkMovie(id: String): Int {
        return localDataSource.checkMovie(id)
    }


    override fun getNowPlayingMovies(): LiveData<PagingData<Movie>> {
        return remoteDataSource.getNowPlayingMovies()
    }

    override fun getSearchMovies(query: String): LiveData<PagingData<Movie>> {
        return remoteDataSource.getSearchMovies(query)
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }


    override fun addToFavorite(favoriteMovie: Movie) {
        localDataSource.addToFavorite(favoriteMovie)
    }


}