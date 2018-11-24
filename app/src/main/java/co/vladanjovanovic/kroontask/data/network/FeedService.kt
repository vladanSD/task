package co.vladanjovanovic.kroontask.data.network

import co.vladanjovanovic.kroontask.data.model.Feed
import io.reactivex.Observable
import retrofit2.http.GET

interface FeedService {

    @GET("/feed")
    fun getFeeds(): Observable<List<Feed>>
}