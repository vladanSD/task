package co.vladanjovanovic.kroontask.data

import co.vladanjovanovic.kroontask.data.database.KroonDatabase
import co.vladanjovanovic.kroontask.data.model.FeedResponse
import co.vladanjovanovic.kroontask.data.network.FeedService
import io.reactivex.Observable
import javax.inject.Inject


class Repository @Inject constructor(val feedService: FeedService, val database: KroonDatabase) {

    fun getFeeds(): Observable<List<FeedResponse>> {
        return feedService.getFeeds()
    }

}