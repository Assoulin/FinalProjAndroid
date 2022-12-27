package com.example.lec17.servises

import com.example.lec17.BuildConfig
import com.example.lec17.models.GenreResponse
import com.example.lec17.models.MovieResponse
import com.example.lec17.network.utils.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TMDBService {
    @GET("3/discover/movie?sort_by=popularity.desc")
    suspend fun popularMovies(): MovieResponse

    @GET("3/genre/movie/list")
    suspend fun genres(): GenreResponse

    //Setup:
    companion object {
        fun create(): TMDBService {
            //print all requests to log
            val logger = HttpLoggingInterceptor()
            logger.level= HttpLoggingInterceptor.Level.BODY

            //Add the Api Key
            val client = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(logger)
                .build()
            //basic retrofit
            return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.TMDB_API_KEY)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TMDBService::class.java)
        }


    }
}