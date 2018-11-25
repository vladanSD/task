package co.vladanjovanovic.kroontask.di.app

import co.vladanjovanovic.kroontask.KroonApp
import co.vladanjovanovic.kroontask.di.AndroidInjectors
import co.vladanjovanovic.kroontask.di.db.RoomModule
import co.vladanjovanovic.kroontask.di.network.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Suppress("DEPRECATION")
@Singleton
@dagger.Component(modules = [(AndroidSupportInjectionModule::class), (ApplicationModule::class), (AndroidInjectors::class), (NetworkModule::class),(RoomModule::class)])
interface ApplicationComponent : AndroidInjector<KroonApp> {
    @dagger.Component.Builder
    abstract class Builder : AndroidInjector.Builder<KroonApp>() {
        abstract override fun build(): ApplicationComponent
    }
}