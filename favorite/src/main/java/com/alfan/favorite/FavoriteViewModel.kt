package com.alfan.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alfan.core.domain.usecase.MovieUseCase

class FavoriteViewModel(
    useCase: MovieUseCase,
) : ViewModel() {
    val favorite = useCase.getFavoriteMovies().asLiveData()
}
