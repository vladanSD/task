package co.vladanjovanovic.kroontask.di.app

import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.di.BuildersModule
import co.vladanjovanovic.kroontask.di.db.RoomModule
import co.vladanjovanovic.kroontask.di.network.NetworkModule
import dagger.Component
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class, NetworkModule::class, RoomModule::class])
interface AppComponent {

    fun inject(application: KroonApp)
}