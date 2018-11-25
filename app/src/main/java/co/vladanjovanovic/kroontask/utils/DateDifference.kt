package co.vladanjovanovic.kroontask.utils

import android.content.Context
import co.vladanjovanovic.kroontask.R
import java.util.*

class DateDifference {

    companion object {
        fun getDifference(post: Date, context: Context): String {
            var difference = Date().time - post.time

            val secondsInMilli: Long = 1000
            val minutesInMilli = secondsInMilli * 60
            val hoursInMilli = minutesInMilli * 60
            val daysInMilli = hoursInMilli * 24

            val elapsedDays = difference / daysInMilli
            difference %= daysInMilli

            val elapsedHours = difference / hoursInMilli
            difference %= hoursInMilli

            val elapsedMinutes = difference / minutesInMilli
            difference %= minutesInMilli

            if(elapsedDays > 0) return elapsedDays.toString() + " " + context.getString(R.string.days)
            if(elapsedHours > 0) return elapsedHours.toString() + " " + context.getString(R.string.hours)
            return elapsedMinutes.toString() + " " + context.getString(R.string.minutes)
        }
    }
}