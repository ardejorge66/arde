package br.com.levisaturnino.starwars.mvp.film
import android.content.Context
import android.util.Log

import br.com.levisaturnino.starwars.database.AppDatabase

import br.com.levisaturnino.starwars.domain.FilmList
import br.com.levisaturnino.starwars.network.FilmService
import br.com.levisaturnino.starwars.network.StarWarsApi


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class FilmModel(val conts: Context,private val presenter: IFilm.FilmPresenterImpl) : IFilm.FilmModelImpl {

    private var database: AppDatabase? = null


    val filmObservable: Observable<FilmList>
        get() = StarWarsApi.client!!.create(FilmService::class.java)
                .films
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    val filmObserver: DisposableObserver<FilmList>
        get() {

            presenter.showProgressBar(true)

            return object : DisposableObserver<FilmList>() {

                override fun onNext(filmList: FilmList) {

                    database!!.filmDao().insertMultipleoFilm(filmList.films)
                    presenter.updateListRecycler(ArrayList(filmList.films))
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "Error$e")
                    e.printStackTrace()

                    presenter.showProgressBar(false)
                }

                override fun onComplete() {
                    Log.d(TAG, "Completed")
                    presenter.showProgressBar(false)
                }
            }
        }

    override fun getFilmsRequest() {

        database = AppDatabase.getAppDatabase(conts)

        var filmsList  =   database!!.filmDao().all

        if(filmsList.size > 1){
            presenter.showProgressBar(false)
            presenter.updateListRecycler(ArrayList(filmsList))
        }else{
            filmObservable.subscribeWith<DisposableObserver<FilmList>>(filmObserver)
        }
    }

    companion object {

        private val TAG = "Films"
    }
}
