package com.example.lec17

import android.app.Application
import android.net.ConnectivityManager
import com.example.lec17.database.AppDatabase
import com.example.lec17.network.NetworkStatusChecker
import com.example.lec17.repository.MovieRepository

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        println("App Started")

        //start analytics
        instance = this
    }

    companion object {
        private lateinit var instance: MoviesApplication

        private val db: AppDatabase by lazy {
            AppDatabase.create(instance)
        }
        val repository: MovieRepository by lazy {
            MovieRepository(db.filmDao())
        }

        val networkStatusChecker: NetworkStatusChecker by lazy {
            val connectivityManager = instance.getSystemService(ConnectivityManager::class.java)
            NetworkStatusChecker(connectivityManager)
        }
    }
}