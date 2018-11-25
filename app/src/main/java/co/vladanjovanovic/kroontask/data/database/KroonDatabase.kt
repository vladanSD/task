package co.vladanjovanovic.kroontask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.vladanjovanovic.kroontask.data.model.Feed


@Database(entities = [Feed::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class KroonDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao
}