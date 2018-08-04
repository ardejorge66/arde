package br.com.levisaturnino.starwars.network


import br.com.levisaturnino.starwars.domain.FilmList
import io.reactivex.Observable
import retrofit2.http.GET


interface FilmService {

    @get:GET("films")
    val films: Observable<FilmList>

  /*  @get:GET("app_novelas_resumo.php")
    val resumo: Observable<Resumo>

    @GET("app_novelas_capitulos.php")
    fun getCapituloNovela(@Query("novela") idNovela: Int): Observable<Novelas>*/


}
