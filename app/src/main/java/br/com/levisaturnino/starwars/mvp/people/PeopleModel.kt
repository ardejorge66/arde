package br.com.levisaturnino.starwars.mvp.people

import android.content.Context
import android.util.Log
import br.com.levisaturnino.starwars.database.AppDatabase
import br.com.levisaturnino.starwars.domain.FilmList

import br.com.levisaturnino.starwars.domain.PeopleList
import br.com.levisaturnino.starwars.network.PeopleService
import br.com.levisaturnino.starwars.network.StarWarsApi
import br.com.levisaturnino.starwars.utils.Utils


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class PeopleModel(val conts: Context,private val presenter: IPeople.PeoplePresenterImpl) : IPeople.PeopleModelImpl {
    private var database: AppDatabase? = null

    val peopleObservable: Observable<PeopleList>
        get() = StarWarsApi.client!!.create(PeopleService::class.java)
                .peoples
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


    val peopleObserver: DisposableObserver<PeopleList>
        get() {

            presenter.showProgressBar(true)

            return object : DisposableObserver<PeopleList>() {

                override fun onNext(peopleList: PeopleList) {
                    database!!.peopleDao().insertMultiplePeople(ArrayList(peopleList.peoples))
                    presenter.updateListRecycler(peopleList.peoples)

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

        database = AppDatabase.getAppDatabase(conts)

        val peopleList  =   database!!.peopleDao().all

        if (Utils.isNetworkAvailable(conts)) {

            if(peopleList.size > 1){
                presenter.showProgressBar(false)
                presenter.updateListRecycler(ArrayList(peopleList))
            }else{
                peopleObservable.subscribeWith<DisposableObserver<PeopleList>>(peopleObserver)
            }
        } else{
            if(peopleList.size > 1){
                presenter.showProgressBar(false)
                presenter.updateListRecycler(ArrayList(peopleList))
            }
        }
    }

    companion object {

        private val TAG = "Peoples"
    }
}
