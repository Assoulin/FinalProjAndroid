package com.example.lec17.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.UUID

data class FGenre(
    @ColumnInfo(name = "film_name")
    val name:String,

    @PrimaryKey
    val genreId:String= UUID.randomUUID().toString(),
) {
}