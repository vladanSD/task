package co.vladanjovanovic.kroontask.data.database

import androidx.room.TypeConverter
import co.vladanjovanovic.kroontask.data.model.FeedType
import java.util.*

class Converters {

    @TypeConverter
    fun timestampToDate(value: Long): Date = Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long = date?.time ?: 0

    @TypeConverter
    fun meToString(value: FeedType?) = value?.name

    @TypeConverter
    fun sToMyEnum(s: String?) = s?.let(FeedType::valueOf)

}