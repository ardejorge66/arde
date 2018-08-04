package br.com.levisaturnino.novelas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.domain.People
import br.com.levisaturnino.starwars.fragments.PeopleFragment
import br.com.levisaturnino.starwars.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_people.view.*


class PeopleAdapter(val activity: PeopleFragment, var peoples: ArrayList<People> ) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_film, parent, false)
        val viewHolder = ViewHolder(view)
        parent.setOnClickListener { }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setDados(peoples[position])

        holder.itemView.cv_proximo.setOnClickListener {
            val film = peoples[position]
            activity.updateItemRecycler(film)
        }
    }

    override fun getItemCount(): Int {
        return peoples.size
    }


    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setDados(people: People) {

            itemView.tv_title?.setText(people.name)
            Picasso.get().load(Utils.getImagePeople(people.url!!))
                    .into(itemView.iv_film)
        }
    }

    fun getPeoplesList(films: ArrayList<People>) {
        this.peoples.clear()
        this.peoples.addAll(films)
        this.notifyDataSetChanged()
    }
}
