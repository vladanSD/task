package co.vladanjovanovic.kroontask.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.MutableLiveData
import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.R
import co.vladanjovanovic.kroontask.data.database.KroonDatabase
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.data.model.NetworkError
import co.vladanjovanovic.kroontask.data.network.FeedService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class Repository @Inject constructor(private val feedService: FeedService, val database: KroonDatabase, val app: KroonApp) {

    val networkError: MutableLiveData<NetworkError> = MutableLiveData()

    fun getFeeds(): Observable<List<Feed>> {
        fetchFeeds()
        return database.feedDao()
            .getFeeds()
    }

    private fun fetchFeeds() {
        if (isNetworkAvailable()) {
            feedService.getFeeds()
                .map { it -> it.getFeeds() }
                .doOnNext { feeds: List<Feed> ->
                    database.feedDao().insertFeeds(feeds)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { e ->
                    networkError.value = NetworkError(e.message, e)}
                .subscribe()
        } else networkError.value = NetworkError(app.getString(R.string.no_internet_connection), null)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }

}