package co.vladanjovanovic.kroontask.di

import co.vladanjovanovic.kroontask.ui.HomeActivity
import co.vladanjovanovic.kroontask.ui.feed.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BuildersModule {

    @ContributesAndroidInjector
    fun homeActivity() : HomeActivity

    @ContributesAndroidInjector
    fun feedFragment() : FeedFragment
}