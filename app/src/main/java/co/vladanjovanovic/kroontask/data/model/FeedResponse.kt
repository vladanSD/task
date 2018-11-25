package co.vladanjovanovic.kroontask.data.model

import com.google.gson.annotations.SerializedName


class FeedResponse {

    @SerializedName("items")
    private val feeds: List<Feed>? = null

    fun getFeeds(): List<Feed> {
        return feeds ?: ArrayList()
    }
}