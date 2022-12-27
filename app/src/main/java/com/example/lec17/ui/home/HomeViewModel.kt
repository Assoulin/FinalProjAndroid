package com.example.lec17.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.example.lec17.MoviesApplication
import com.example.lec17.database.AppDatabase
import com.example.lec17.models.FilmsWithGenres
import com.example.lec17.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    lateinit var films: LiveData<List<FilmsWithGenres>>// = MutableLiveData()
    init {

        viewModelScope.launch(Dispatchers.IO) {
            films = MoviesApplication.repository.getFilmsWithGenres()
        }
    }
}
