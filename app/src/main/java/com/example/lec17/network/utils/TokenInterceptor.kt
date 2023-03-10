package com.example.lec17.network.utils

import com.example.lec17.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var original =
            chain.request()//https://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc
        val url = original.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
        val request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}