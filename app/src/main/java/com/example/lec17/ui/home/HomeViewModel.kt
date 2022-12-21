package com.example.lec17.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.example.lec17.database.AppDatabase
import com.example.lec17.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val people: LiveData<List<Person>>

    init {
        val db = AppDatabase.create(application)
        people = db.peopleDao().getAll()

        viewModelScope.launch(Dispatchers.IO) {
            db.peopleDao().add(Person("Dave"))
        }
    }
}