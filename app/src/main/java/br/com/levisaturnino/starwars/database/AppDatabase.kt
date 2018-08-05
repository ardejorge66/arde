package br.com.levisaturnino.starwars.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.levisaturnino.Films.dao.FilmDao
import br.com.levisaturnino.novelas.dao.PeopleDao
import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.domain.People


@Database(entities = arrayOf(Film::class,People::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun filmDao(): FilmDao
    abstract fun peopleDao(): PeopleDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (AppDatabase.INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    AppDatabase.INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase::class.java, "starwars.db")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return AppDatabase.INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

    }
}
