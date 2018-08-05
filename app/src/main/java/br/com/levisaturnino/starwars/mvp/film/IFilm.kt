package br.com.levisaturnino.starwars.mvp.film

import android.content.Context
import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.domain.FilmList

interface IFilm {

    interface FilmModelImpl {
        fun getFilmsRequest()
    }

    interface FilmPresenterImpl {
        val context: Context
        fun showProgressBar(status: Boolean)
        fun setView(view: FilmViewImpl)
        fun updateListRecycler(films: ArrayList<Film>)
        fun getFilmsRequest()
    }

    interface FilmViewImpl {
        fun updateListRecycler(films: ArrayList<Film>)
        fun updateItemRecycler(film: Film)
        fun showProgressBar(visibilidade: Int)

        companion object {
            val FILM_KEY = "film"
        }
    }
}
