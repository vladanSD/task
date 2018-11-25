package co.vladanjovanovic.kroontask.ui.feed

import android.util.Log
import androidx.lifecycle.ViewModel
import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.data.Repository
import co.vladanjovanovic.kroontask.data.model.Feed
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeedViewModel@Inject constructor(val repository: Repository) : ViewModel(){

    private var feeds: ArrayList<Feed> = ArrayList()

    private lateinit var feedsDisposable: DisposableObserver<List<Feed>>

    fun fetchFeeds() {
        feedsDisposable = object : DisposableObserver<List<Feed>>() {
            override fun onComplete() {
            }

            override fun onNext(users: List<Feed>) {
                this@FeedViewModel.feeds.addAll(users)
            }

            override fun onError(e: Throwable) {
                Log.i("OVDE", "error")
            }
        }

        repository.getFeeds()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(feedsDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        if (!feedsDisposable.isDisposed) feedsDisposable.dispose()
    }
}