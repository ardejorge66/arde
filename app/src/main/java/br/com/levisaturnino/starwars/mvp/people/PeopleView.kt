package br.com.levisaturnino.starwars.mvp.people


import br.com.levisaturnino.starwars.domain.People
import java.util.ArrayList


class PeopleView : IPeople.PeopleViewImpl {


    override fun updateListRecycler(peoples: ArrayList<People>) {
    }

    override fun updateItemRecycler(people: People) {
    }

    override fun showProgressBar(visibilidade: Int) {
    }

}
