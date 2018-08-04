package br.com.levisaturnino.starwars.fragments

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.levisaturnino.novelas.adapter.PeopleAdapter
import br.com.levisaturnino.novelas.mvp.proximocapitulo.IPeople
import br.com.levisaturnino.novelas.mvp.proximocapitulo.PeoplePresenter
import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.domain.People
import br.com.levisaturnino.starwars.utils.InternetFragment
import kotlinx.android.synthetic.main.fragment_people.view.*


class PeopleFragment :  InternetFragment(), IPeople.PeopleViewImpl, SwipeRefreshLayout.OnRefreshListener {

    private var presenter: IPeople.PeoplePresenterImpl? = null
    private var PeopleAdapter: PeopleAdapter? = null

    lateinit var inflate : View

    override fun updateItemRecycler(People: People) {
     /*   val intent = Intent(activity, PeopleDetailActivity::class.java)

        intent.putExtra(IPeople.PeopleViewImpl.People_KEY, People)

        startActivity(intent)*/

    }


    override fun updateListRecycler(Peoples: ArrayList<People>) {

        PeopleAdapter!!.getPeoplesList(Peoples)
        PeopleAdapter!!.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_people, container, false)



        if (presenter == null) {
            presenter = PeoplePresenter()
        }
        presenter!!.setView(this)

        inflate.sr_people.setOnRefreshListener(this)


        inflate.rv_people.layoutManager = GridLayoutManager(activity, 2)
        inflate.rv_people.itemAnimator = DefaultItemAnimator()
        inflate.rv_people.setHasFixedSize(true)

        PeopleAdapter = PeopleAdapter(this ,arrayListOf<People>() )

        inflate.rv_people.adapter = PeopleAdapter

        presenter!!.getPeoplesRequest()

        return inflate
    }


    override fun showProgressBar(visibilidade: Int) {
        if (inflate.sr_people?.isRefreshing!!) {
            inflate.sr_people?.isRefreshing = false

        } else if (visibilidade == 8) {
            inflate.pb_loading.setVisibility(View.GONE)
        } else {
            inflate.pb_loading.setVisibility(visibilidade)

        }
    }

    override fun onRefresh() {
        presenter?.getPeoplesRequest()
    }


    override fun iniciarDownload() {
        presenter?.getPeoplesRequest()
    }


}
