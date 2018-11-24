package co.vladanjovanovic.kroontask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "feeds")
data class Feed(
    @PrimaryKey
    val uid: String,
    val type: FeedType,
    val creationTime: Date,
    val authorName: String,
    val authorAvatarUrl: String,
    val message: String
)