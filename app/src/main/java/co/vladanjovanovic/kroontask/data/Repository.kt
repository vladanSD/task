package co.vladanjovanovic.kroontask.data

import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.data.network.FeedService
import io.reactivex.Observable
import javax.inject.Inject

class Repository @Inject constructor(val feedService: FeedService) {

    fun getFeeds() : Observable<List<Feed>> {
        return feedService.getFeeds()
    }

}