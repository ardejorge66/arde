package br.com.levisaturnino.starwars.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import br.com.levisaturnino.starwars.R
import br.com.levisaturnino.starwars.domain.People
import br.com.levisaturnino.starwars.fragments.FilmFragment
import br.com.levisaturnino.starwars.fragments.PeopleFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var fragmentTransaction: FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        switchFragment(FilmFragment())


    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_film -> {
                switchFragment(FilmFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_characters -> {
                switchFragment(PeopleFragment())
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    private fun switchFragment(fragment: Fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
        fragmentTransaction!!.replace(R.id.content, fragment)
        fragmentTransaction!!.commit()
    }
}
