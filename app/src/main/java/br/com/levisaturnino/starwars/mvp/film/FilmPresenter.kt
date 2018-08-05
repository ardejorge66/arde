package br.com.levisaturnino.starwars.mvp.film


import android.content.Context
import android.view.View

import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.utils.Utils

import java.util.*

class FilmPresenter(val conts: Context) : IFilm.FilmPresenterImpl {

    private val model: IFilm.FilmModelImpl
    private var view: IFilm.FilmViewImpl? = null


    override fun setView(view: IFilm.FilmViewImpl) {
        this.view = view    }

    override fun updateListRecycler(films: ArrayList<Film>) {
        view!!.updateListRecycler(films)    }

    override val context: Context
        get() = (view as Context?)!!

    init {
        this.model = FilmModel(conts,this)
    }


    override fun getFilmsRequest() {

        if (Utils.isNetworkAvailable(conts)) {
            model.getFilmsRequest()
        } else {
            Utils.getMessage(conts)
        }

    }


    override fun showProgressBar(status: Boolean) {
        val visibilidade = if (status) View.VISIBLE else View.GONE
        view?.showProgressBar(visibilidade)
    }

}
