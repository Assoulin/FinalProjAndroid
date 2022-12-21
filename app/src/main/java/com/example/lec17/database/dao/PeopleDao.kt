package com.example.lec17.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.lec17.models.Person

@Dao
interface PeopleDao {
    @Insert(onConflict = REPLACE)
    suspend fun add(person:Person)

    @Query("SELECT * FROM people")
    fun getAll():LiveData<List<Person>>
}