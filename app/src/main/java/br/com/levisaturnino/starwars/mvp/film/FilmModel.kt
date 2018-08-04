package br.com.levisaturnino.novelas.mvp.proximocapitulo

import android.util.Log

import br.com.levisaturnino.starwars.domain.FilmList
import br.com.levisaturnino.starwars.network.FilmService
import br.com.levisaturnino.starwars.network.StarWarsApi


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class FilmModel(private val presenter: IFilm.FilmPresenterImpl) : IFilm.FilmModelImpl {

    val proximoCapituloObservable: Observable<FilmList>
        get() = StarWarsApi.client!!.create(FilmService::class.java)
                .films
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


    //   showProgressBar(false);
    val filmObserver: DisposableObserver<FilmList>
        get() {

            presenter.showProgressBar(true)

            return object : DisposableObserver<FilmList>() {

                override fun onNext(filmList: FilmList) {
                    presenter.updateListRecycler(filmList.films)

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
        proximoCapituloObservable.subscribeWith<DisposableObserver<FilmList>>(filmObserver)
    }

    companion object {

        private val TAG = "Films"
    }
}
