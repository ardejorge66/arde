package br.com.levisaturnino.novelas.mvp.proximocapitulo


import android.content.Context
import android.view.View
import br.com.levisaturnino.starwars.domain.Film

import java.util.*

class FilmPresenter : IFilm.FilmPresenterImpl {

    private val model: IFilm.FilmModelImpl
    private var view: IFilm.FilmViewImpl? = null


    override fun setView(view: IFilm.FilmViewImpl) {
        this.view = view    }

    override fun updateListRecycler(films: ArrayList<Film>) {
        view!!.updateListRecycler(films)    }

    override val context: Context
        get() = (view as Context?)!!

    init {
        this.model = FilmModel(this)
    }


    override fun getFilmsRequest() {
       // if (Utils.isNetworkAvailable(context)) {
       // if (Utils.isNetworkAvailable(context)) {
            model.getFilmsRequest()
        /*} else {
            Utils.getMessage(context)
        }*/

    }


    override fun showProgressBar(status: Boolean) {
        val visibilidade = if (status) View.VISIBLE else View.GONE
        view?.showProgressBar(visibilidade)
    }


}
