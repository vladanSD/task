package co.vladanjovanovic.kroontask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "feeds")
data class Feed(
    @PrimaryKey
    @SerializedName("uid")
    val uid: String,
    @SerializedName("type")
    val type: FeedType,
    @SerializedName("creationTime")
    val creationTime: Date,
    @SerializedName("authorName")
    val authorName: String,
    @SerializedName("authorAvatarUrl")
    val authorAvatarUrl: String,
    @SerializedName("message")
    val message: String
)