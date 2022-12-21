package com.example.lec17.models

import androidx.room.*
import java.util.UUID

@Entity
data class Film(
    val title: String,
    @PrimaryKey
    val filmId: String = UUID.randomUUID().toString(),
)

@Entity(primaryKeys = ["filmId", "genreId"])
data class FilmGenreCrossRef(
    val filmId: String,
    val genreId: String

)

data class FilmsWithGenres(
    @Embedded
    val film: Film,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "genreId",
        associateBy = Junction(FilmGenreCrossRef::class)
    )
    val genres: List<FGenre>,
)

data class FilmWithReviews(
    @Embedded
    val film: Film,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "reviewedFilmId"
    )
    val reviews: List<Review>?,
)