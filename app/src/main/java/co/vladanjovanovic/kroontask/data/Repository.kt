package co.vladanjovanovic.kroontask.data

import androidx.room.RoomDatabase
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.data.network.FeedService
import io.reactivex.Observable
import javax.inject.Inject

class Repository @Inject constructor(val feedService: FeedService, val database: RoomDatabase) {

    fun getFeeds() : Observable<List<Feed>> {
        return feedService.getFeeds()
    }

}