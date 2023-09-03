package com.alfan.core.utils

import com.alfan.core.data.source.local.entity.FavoriteMovie
import com.alfan.core.domain.model.Movie

object DataMapper {
    fun mapEntitiesToDomain(input: List<FavoriteMovie>): List<Movie> =
        input.map {
            Movie(
                id = it.id_movie,
                overview = it.overview,
                poster_path = it.poster_path,
                original_title = it.original_title,
                )
        }
}