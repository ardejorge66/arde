package br.com.levisaturnino.starwars.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.levisaturnino.novelas.adapter.FilmAdapter


import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.activities.FilmDetailActivity
import br.com.levisaturnino.starwars.database.AppDatabase
import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.mvp.film.FilmPresenter
import br.com.levisaturnino.starwars.mvp.film.IFilm
import br.com.levisaturnino.starwars.utils.InternetFragment
import kotlinx.android.synthetic.main.fragment_film.view.*
import java.util.ArrayList


class FilmFragment : InternetFragment(), IFilm.FilmViewImpl, SwipeRefreshLayout.OnRefreshListener {

    private var presenter: IFilm.FilmPresenterImpl? = null
    private var filmAdapter: FilmAdapter? = null

    lateinit var inflate : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         inflate = inflater.inflate(R.layout.fragment_film, container, false)



        if (presenter == null) {
            presenter = FilmPresenter(context!!)
        }
        presenter!!.setView(this)

        inflate.sr_film.setOnRefreshListener(this)


        inflate.rv_film.layoutManager = GridLayoutManager(activity, 2)
        inflate.rv_film.itemAnimator = DefaultItemAnimator()
        inflate.rv_film.setHasFixedSize(true)

        filmAdapter = FilmAdapter(this ,arrayListOf<Film>() )

        inflate.rv_film.adapter = filmAdapter

        presenter!!.getFilmsRequest()

        return inflate
    }


    override fun updateItemRecycler(film: Film) {

        val intent = Intent(activity, FilmDetailActivity::class.java)

        intent.putExtra(IFilm.FilmViewImpl.FILM_KEY, film)

        startActivity(intent)

    }


    override fun updateListRecycler(films: ArrayList<Film>) {



        filmAdapter!!.getFilmsList(ArrayList(films))
        filmAdapter!!.notifyDataSetChanged()
    }

    override fun showProgressBar(visibilidade: Int) {
        if (inflate.sr_film?.isRefreshing!!) {
            inflate.sr_film?.isRefreshing = false

        } else if (visibilidade == 8) {
            inflate.pb_loading.setVisibility(View.GONE)
        } else {
            inflate.pb_loading.setVisibility(visibilidade)

        }
    }

    override fun onRefresh() {
        presenter?.getFilmsRequest()
    }


    override fun iniciarDownload() {
        presenter?.getFilmsRequest()
    }


}
