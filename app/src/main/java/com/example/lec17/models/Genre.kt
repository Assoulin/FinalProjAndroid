package com.example.lec17.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Genre(
    @PrimaryKey
    @SerializedName("id")
    val genreId:Long,
    val name:String,
    @SerializedName("status_code")
    val statusCode: String?,
    @SerializedName("status_message")
    val statusMessage: String?,
    val success: Boolean?,
) {
}