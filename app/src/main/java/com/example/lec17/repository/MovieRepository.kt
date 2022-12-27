package com.example.lec17.repository

import androidx.lifecycle.LiveData
import com.example.lec17.database.dao.FilmDao
import com.example.lec17.models.FilmsWithGenres
import kotlinx.coroutines.Dispatchers

class MovieRepository(private val filmDao:FilmDao){
    suspend fun getFilmsWithGenres():LiveData<List<FilmsWithGenres>>{
        return with(Dispatchers.IO){
            //fetch data from remote data source
            filmDao.getFilmsWithGenres()
        }
    }
}