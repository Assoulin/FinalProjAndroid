package com.example.lec17.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Review(
    val text:String,
    val reviewedFilmId:String,
    @PrimaryKey
    val reviewId:String=UUID.randomUUID().toString()
) {
}