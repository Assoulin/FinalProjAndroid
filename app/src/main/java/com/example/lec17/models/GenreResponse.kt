package com.example.lec17.models


import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("results")
    val genres: List<Genre>,
    @SerializedName("status_message")
    val statusMessage: String?,
    val success: Boolean?,
)