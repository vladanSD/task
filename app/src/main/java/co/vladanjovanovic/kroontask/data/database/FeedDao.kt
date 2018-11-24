package co.vladanjovanovic.kroontask.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.vladanjovanovic.kroontask.data.model.Feed
import io.reactivex.Observable

@Dao
interface FeedDao {

    @Query("SELECT * FROM feeds")
    fun getFeeds(): Observable<Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeeds(feeds: List<Feed>)

    @Query("DELETE FROM feeds")
    fun deleteAllFeeds()
}