package co.vladanjovanovic.kroontask

import android.app.Activity
import android.app.Application
import android.app.Fragment
import co.vladanjovanovic.kroontask.di.app.AppModule
import co.vladanjovanovic.kroontask.di.app.DaggerAppComponent
import co.vladanjovanovic.kroontask.di.network.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

@Suppress("DEPRECATION")
class KroonApp : Application(), HasActivityInjector, HasFragmentInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule(NetworkModule.BASE_URL))
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
    override fun fragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

}