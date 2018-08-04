package br.com.levisaturnino.novelas.mvp.proximocapitulo


import android.content.Context
import android.view.View
import br.com.levisaturnino.starwars.domain.People

import java.util.*

class PeoplePresenter : IPeople.PeoplePresenterImpl {

    private val model: IPeople.PeopleModelImpl
    private var view: IPeople.PeopleViewImpl? = null


    override fun setView(view: IPeople.PeopleViewImpl) {
        this.view = view    }

    override fun updateListRecycler(Peoples: ArrayList<People>) {
        view!!.updateListRecycler(Peoples)    }

    override val context: Context
        get() = (view as Context?)!!

    init {
        this.model = PeopleModel(this)
    }


    override fun getPeoplesRequest() {
       // if (Utils.isNetworkAvailable(context)) {
            model.getPeoplesRequest()
        /*} else {
            Utils.getMessage(context)
        }*/

    }


    override fun showProgressBar(status: Boolean) {
        val visibilidade = if (status) View.VISIBLE else View.GONE
        view?.showProgressBar(visibilidade)
    }


}
