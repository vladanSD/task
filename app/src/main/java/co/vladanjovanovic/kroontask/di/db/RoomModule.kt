package co.vladanjovanovic.kroontask.di.db

import androidx.room.Room
import androidx.room.RoomDatabase
import co.vladanjovanovic.kroontask.KroonApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoom(app: KroonApp) : RoomDatabase {
        return Room.databaseBuilder(app, RoomDatabase::class.java, "kroon_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}