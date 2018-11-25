package co.vladanjovanovic.kroontask.ui.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.data.Repository
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.data.model.FeedResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeedViewModel@Inject constructor(val repository: Repository) : ViewModel(){

//    private var feeds: ArrayList<Feed> = ArrayList()

    var feeds: MutableLiveData<List<Feed>> = MutableLiveData()

    private lateinit var feedsDisposable: DisposableObserver<List<FeedResponse>>

    fun fetchFeeds() {
        feedsDisposable = object : DisposableObserver<List<FeedResponse>>() {
            override fun onComplete() {
            }

            override fun onNext(feeds: List<FeedResponse>) {
                this@FeedViewModel.feeds.value = feeds[0].getFeeds()
            }

            override fun onError(e: Throwable) {
                Log.i("OVDE", "error")
                e.printStackTrace()
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