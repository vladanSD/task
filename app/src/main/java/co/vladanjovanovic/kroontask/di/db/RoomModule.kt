package co.vladanjovanovic.kroontask.di.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoom(context: Context) : RoomDatabase {
        return Room.databaseBuilder(context, RoomDatabase::class.java, "kroon_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}