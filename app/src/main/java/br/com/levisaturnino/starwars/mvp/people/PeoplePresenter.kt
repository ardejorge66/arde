package br.com.levisaturnino.starwars.mvp.people


import android.content.Context
import android.view.View


import br.com.levisaturnino.starwars.domain.People
import br.com.levisaturnino.starwars.utils.Utils

import java.util.*

class PeoplePresenter(val conts: Context) : IPeople.PeoplePresenterImpl {

    private val model: IPeople.PeopleModelImpl
    private var view: IPeople.PeopleViewImpl? = null


    override fun setView(view: IPeople.PeopleViewImpl) {
        this.view = view    }

    override fun updateListRecycler(Peoples: ArrayList<People>) {
        view!!.updateListRecycler(Peoples)    }

    override val context: Context
        get() = (view as Context?)!!

    init {
        this.model = PeopleModel(conts,this)
    }


    override fun getPeoplesRequest() {
       if (Utils.isNetworkAvailable(conts)) {
            model.getPeoplesRequest()
        } else {
            Utils.getMessage(conts)
        }

    }


    override fun showProgressBar(status: Boolean) {
        val visibilidade = if (status) View.VISIBLE else View.GONE
        view?.showProgressBar(visibilidade)
    }


}
