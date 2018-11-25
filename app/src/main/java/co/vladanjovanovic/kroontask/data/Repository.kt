package co.vladanjovanovic.kroontask.data

import co.vladanjovanovic.kroontask.data.database.KroonDatabase
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.data.network.FeedService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class Repository @Inject constructor(val feedService: FeedService, val database: KroonDatabase) {

    fun getFeeds(): Observable<List<Feed>> {
        return database.feedDao().getFeeds()
    }

    fun fetchFeeds() {
        feedService.getFeeds()
            .map { it -> it.getFeeds() }
            .doOnNext { feeds: List<Feed> ->
                database.feedDao().insertFeeds(feeds)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { e -> e.printStackTrace() }
            .subscribe()

    }

}