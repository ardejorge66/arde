package br.com.levisaturnino.novelas.dao


import android.arch.persistence.room.*
import br.com.levisaturnino.starwars.domain.People


@Dao
interface PeopleDao {

    @get:Query("SELECT * FROM people")
    val all: List<People>

    @Insert
    fun insertOnlySinglePeople(people: People)

    @Insert
    fun insertMultiplePeople(people: List<People>)

    @Update
    fun updatePeople(people: People)

    @Delete
    fun deletePeople(people: People)
}