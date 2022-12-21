package com.example.lec17.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.example.lec17.models.Dog
import com.example.lec17.models.Person
import com.example.lec17.models.PersonWithDog

@Dao
interface PeopleDao {
    @Insert(onConflict = REPLACE)
    suspend fun add(person:Person)

    @Query("SELECT * FROM people")
    fun getAll():LiveData<List<Person>>

    @Insert(onConflict = REPLACE)
    suspend fun add(dog: Dog)

    @Query("SELECT * FROM Dog")
    fun getDogs():LiveData<List<Dog>>

    @Transaction
    @Query("SELECT * FROM people")
    fun getPeopleWithDog():LiveData<List<PersonWithDog>>
}