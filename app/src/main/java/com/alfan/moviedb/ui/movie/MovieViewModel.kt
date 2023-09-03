package com.alfan.moviedb.ui.movie

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.alfan.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase,
    state: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val EMPTY_QUERY = ""
    }

    private val currentQuery = state.getLiveData(CURRENT_QUERY, EMPTY_QUERY)


    val movies = currentQuery.switchMap { query ->
        if (query.isNotEmpty()) {
            movieUseCase.getSearchMovies(query)
        } else {
            movieUseCase.getNowPlayingMovies().cachedIn(viewModelScope)
        }
    }

}