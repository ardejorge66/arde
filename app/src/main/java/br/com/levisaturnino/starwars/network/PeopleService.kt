package br.com.levisaturnino.starwars.network


import br.com.levisaturnino.starwars.domain.FilmList
import br.com.levisaturnino.starwars.domain.People
import br.com.levisaturnino.starwars.domain.PeopleList
import io.reactivex.Observable
import retrofit2.http.GET


interface PeopleService {

    @get:GET("people")
    val peoples: Observable<PeopleList>


}
