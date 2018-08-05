package br.com.levisaturnino.starwars.mvp.people

import android.content.Context
import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.domain.FilmList
import br.com.levisaturnino.starwars.domain.People

interface IPeople {

    interface PeopleModelImpl {
        fun getPeoplesRequest()
    }

    interface PeoplePresenterImpl {
        val context: Context
        fun showProgressBar(status: Boolean)
        fun setView(view: PeopleViewImpl)
        fun updateListRecycler(peoples: ArrayList<People>)
        fun getPeoplesRequest()
    }

    interface PeopleViewImpl {
        fun updateListRecycler(peoples: ArrayList<People>)
        fun updateItemRecycler(people: People)
        fun showProgressBar(visibilidade: Int)

        companion object {
            val People_KEY = "People"
        }
    }
}
