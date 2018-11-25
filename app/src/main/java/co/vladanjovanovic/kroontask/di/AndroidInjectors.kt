package co.vladanjovanovic.kroontask.di

import co.vladanjovanovic.kroontask.ui.HomeActivity
import co.vladanjovanovic.kroontask.ui.feed.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidInjectors {

    @ContributesAndroidInjector
    abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun feedFragment(): FeedFragment


}