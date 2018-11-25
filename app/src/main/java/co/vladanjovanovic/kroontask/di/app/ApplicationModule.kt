package co.vladanjovanovic.kroontask.di.app

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.data.Repository
import co.vladanjovanovic.kroontask.data.database.KroonDatabase
import co.vladanjovanovic.kroontask.data.network.FeedService
import co.vladanjovanovic.kroontask.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: KroonApp): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideRepository(feedService: FeedService, database: KroonDatabase, application: KroonApp) : Repository = Repository(feedService, database, application)

    @Provides
    @Singleton
    fun getViewModelFactory(repository: Repository): ViewModelProvider.Factory =
        ViewModelFactory(repository)
}
