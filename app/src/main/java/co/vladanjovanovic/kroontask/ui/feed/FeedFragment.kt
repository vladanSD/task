package co.vladanjovanovic.kroontask.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.vladanjovanovic.kroontask.R
import co.vladanjovanovic.kroontask.di.viewmodel.ViewModelFactoryModule
import dagger.android.AndroidInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FeedFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactoryModule: ViewModelFactoryModule
    private lateinit var feedViewModel: FeedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }


}