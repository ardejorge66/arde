package br.com.levisaturnino.starwars.activities

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.MenuItem
import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.domain.People
import br.com.levisaturnino.starwars.mvp.people.IPeople
import br.com.levisaturnino.starwars.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.content_character.*
import android.support.v4.content.ContextCompat
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Html.fromHtml
import android.text.Spanned






class CharacterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        val bundle = intent

        if (bundle != null) {

            val people = intent.getParcelableExtra(IPeople.PeopleViewImpl.People_KEY) as People

            tv_birth_year?.text = Utils.fromHtml(getString(R.string.birth_year,people.birth_year))

            tv_gender2?.text = Utils.fromHtml(getString(R.string.gender,people.gender))

            tv_heigth?.text = Utils.fromHtml(getString(R.string.height,people.height))

            tv_hair_color?.text = Utils.fromHtml(getString(R.string.hair_color,people.hair_color))

            tv_skin_color?.text = Utils.fromHtml(getString(R.string.skin_color,people.skin_color))

            tv_mass?.text = Utils.fromHtml(getString(R.string.mass,people.mass))

            Picasso.get().load(Utils.getImagePeople(people.url!!))
                    .into(iv_people_detail)

            setTitle(people.name)
        }
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)

    }
}
