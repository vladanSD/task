package co.vladanjovanovic.kroontask.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@Module
class ViewModelFactoryModule @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>,
        Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T

}