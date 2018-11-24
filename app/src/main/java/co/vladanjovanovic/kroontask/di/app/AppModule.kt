package co.vladanjovanovic.kroontask.di.app

import android.content.Context
import co.vladanjovanovic.kroontask.KroonApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: KroonApp) {

    @Provides
    @Singleton
    fun provideApplication(): KroonApp = app

    @Provides
    @Singleton
    fun provideAppContext() : Context = app.applicationContext
}