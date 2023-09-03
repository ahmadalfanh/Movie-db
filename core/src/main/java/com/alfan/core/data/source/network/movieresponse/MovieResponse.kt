package com.alfan.core.data.source.network.movieresponse

import com.alfan.core.domain.model.Movie

data class MovieResponse(
    val results: List<Movie>
)