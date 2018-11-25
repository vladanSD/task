package co.vladanjovanovic.kroontask.ui.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.vladanjovanovic.kroontask.data.Repository
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.data.model.NetworkError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeedViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    var feeds: MutableLiveData<List<Feed>> = MutableLiveData()
    private lateinit var feedsDisposable: DisposableObserver<List<Feed>>

    var networkError: MutableLiveData<NetworkError> = repository.networkError

    fun getFeeds() {
        feedsDisposable = object : DisposableObserver<List<Feed>>() {
            override fun onComplete() {
            }

            override fun onNext(feeds: List<Feed>) {
                this@FeedViewModel.feeds.value = feeds
            }

            override fun onError(e: Throwable) {
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