package br.com.levisaturnino.starwars.mvp.film

import br.com.levisaturnino.starwars.domain.Film
import java.util.ArrayList


class FilmView : IFilm.FilmViewImpl {


    override fun updateListRecycler(films: ArrayList<Film>) {
    }

    override fun updateItemRecycler(film: Film) {
    }

    override fun showProgressBar(visibilidade: Int) {
    }

}
