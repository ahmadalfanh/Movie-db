package com.alfan.moviedb.ui.details

import androidx.lifecycle.ViewModel
import com.alfan.core.domain.model.Movie
import com.alfan.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsMovieModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun addToFavorite(movie: Movie) =
        movieUseCase.addToFavorite(movie)

    fun removeFromFavorite(id: String) = movieUseCase.removeFromFavorite(id)

    fun checkMovie(id: String) = movieUseCase.checkMovie(id)
}





