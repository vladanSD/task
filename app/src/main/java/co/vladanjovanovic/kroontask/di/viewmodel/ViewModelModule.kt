package co.vladanjovanovic.kroontask.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import co.vladanjovanovic.kroontask.ui.feed.FeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factoryModule: ViewModelFactoryModule): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    internal abstract fun feedViewModel(viewModel: FeedViewModel): FeedViewModel
}