package br.com.levisaturnino.starwars.mvp.people


import android.content.Context
import android.view.View


import br.com.levisaturnino.starwars.domain.People

import java.util.*

class PeoplePresenter( conts: Context) : IPeople.PeoplePresenterImpl {

    private val model: IPeople.PeopleModelImpl
    private var view: IPeople.PeopleViewImpl? = null


    override fun setView(view: IPeople.PeopleViewImpl) {
        this.view = view    }

    override fun updateListRecycler(peoples: ArrayList<People>) {
        view!!.updateListRecycler(peoples)    }

    override val context: Context
        get() = (view as Context?)!!

    init {
        this.model = PeopleModel(conts,this)
    }


    override fun getPeoplesRequest() {

            model.getPeoplesRequest()
    }


    override fun showProgressBar(status: Boolean) {
        val visibilidade = if (status) View.VISIBLE else View.GONE
        view?.showProgressBar(visibilidade)
    }


}
