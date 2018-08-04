package br.com.levisaturnino.novelas.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.domain.Film
import br.com.levisaturnino.starwars.fragments.FilmFragment
import br.com.levisaturnino.starwars.utils.Utils

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_film.view.*



class FilmAdapter(val activity: FilmFragment,var films: ArrayList<Film> ) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_film, parent, false)
        val viewHolder = ViewHolder(view)
        parent.setOnClickListener { }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setDados(films[position])

        holder.itemView.cv_proximo.setOnClickListener {
            val film = films[position]
            activity.updateItemRecycler(film)
        }
    }

    override fun getItemCount(): Int {
        return films.size
    }


    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setDados(film: Film) {

            itemView.tv_title?.setText(film.title)
            Picasso.get().load(Utils.getImage(film.url))
                    .into(itemView.iv_film)
        }
    }

    fun getFilmsList(films: ArrayList<Film>) {
        this.films.clear()
        this.films.addAll(films)
        this.notifyDataSetChanged()
    }
}
