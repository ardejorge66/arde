package br.com.levisaturnino.novelas.mvp.proximocapitulo

import android.util.Log

import br.com.levisaturnino.starwars.domain.PeopleList
import br.com.levisaturnino.starwars.network.PeopleService
import br.com.levisaturnino.starwars.network.StarWarsApi


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PeopleModel(private val presenter: IPeople.PeoplePresenterImpl) : IPeople.PeopleModelImpl {

    val proximoCapituloObservable: Observable<PeopleList>
        get() = StarWarsApi.client!!.create(PeopleService::class.java)
                .peoples
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


    val PeopleObserver: DisposableObserver<PeopleList>
        get() {

            presenter.showProgressBar(true)

            return object : DisposableObserver<PeopleList>() {

                override fun onNext(PeopleList: PeopleList) {
                    presenter.updateListRecycler(PeopleList.peoples)

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

    override fun getPeoplesRequest() {
        proximoCapituloObservable.subscribeWith<DisposableObserver<PeopleList>>(PeopleObserver)
    }

    companion object {

        private val TAG = "Peoples"
    }
}
