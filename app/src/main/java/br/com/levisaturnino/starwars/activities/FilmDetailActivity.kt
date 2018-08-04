package br.com.levisaturnino.starwars.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.levisaturnino.novelas.mvp.proximocapitulo.IFilm
import br.com.levisaturnino.novelas.mvp.proximocapitulo.IPeople
import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_film_detail.*

class FilmDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)

        val bundle = intent

        if (bundle != null) {

            var film = intent.getParcelableExtra(IFilm.FilmViewImpl.FILM_KEY) as Film

            tv_title?.text = film?.title
            tv_director?.text = film?.director
            tv_opening_crawl?.text = film?.opening_crawl
            tv_release_date?.text = film?.release_date
            tv_producer?.text = film?.producer
            Picasso.get().load(Utils.getImage(film.url))
                    .into(iv_film)
        }
    }
}
