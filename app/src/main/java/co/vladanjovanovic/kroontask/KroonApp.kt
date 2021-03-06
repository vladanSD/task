package co.vladanjovanovic.kroontask

import co.vladanjovanovic.kroontask.di.app.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


@Suppress("DEPRECATION")
class KroonApp : DaggerApplication() {

    val injector: AndroidInjector<KroonApp> = DaggerApplicationComponent.builder().create(this)

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>  = injector

}