package co.vladanjovanovic.kroontask.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.vladanjovanovic.kroontask.data.Repository
import co.vladanjovanovic.kroontask.ui.feed.FeedViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FeedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FeedViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}