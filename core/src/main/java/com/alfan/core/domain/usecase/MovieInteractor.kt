package com.alfan.core.domain.usecase

import com.alfan.core.domain.model.Movie
import com.alfan.core.domain.repository.IMovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository) :
    MovieUseCase {

    override fun removeFromFavorite(id: String) = movieRepository.removeFromFavorite(id)

    override fun checkMovie(id: String): Int = movieRepository.checkMovie(id)
    override fun getNowPlayingMovies() = movieRepository.getNowPlayingMovies()

    override fun getSearchMovies(query: String) = movieRepository.getSearchMovies(query)
    override fun getFavoriteMovies() = movieRepository.getFavoriteMovies()
    override fun addToFavorite(favoriteMovie: Movie) {
        movieRepository.addToFavorite(favoriteMovie)
    }


}