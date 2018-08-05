package br.com.levisaturnino.starwars.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html

import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.mvp.film.IFilm
import br.com.levisaturnino.starwars.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_film_detail.*

class FilmDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)

        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        val bundle = intent

        if (bundle != null) {

            var film = intent.getParcelableExtra(IFilm.FilmViewImpl.FILM_KEY) as Film

            tv_title?.text = ""

            tv_director?.text = Html.fromHtml(getString(R.string.director,film?.director))

            tv_opening_crawl?.text = Html.fromHtml(getString(R.string.opening_crawl,film?.opening_crawl))

            tv_release_date?.text = Html.fromHtml(getString(R.string.data_create,film?.release_date))

            tv_producer?.text = Html.fromHtml(getString(R.string.producer,film?.producer))

            Picasso.get().load(Utils.getImage(film.url))
                    .into(iv_people)

            setTitle("Film "+film?.title)
        }
    }
}
