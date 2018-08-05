package br.com.levisaturnino.Films.dao

import android.arch.persistence.room.*

import br.com.levisaturnino.starwars.domain.Film


@Dao
interface FilmDao {

    @get:Query("SELECT * FROM film")
    val all: List<Film>

    @Insert
    fun insertOnlySingleFilm(Film: Film)

    @Insert
    fun insertMultipleoFilm(films: List<Film>)

    @Update
    fun updateFilm(vararg film: Film)

    @Delete
    fun deleteFilm(vararg film: Film)
}