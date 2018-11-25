package co.vladanjovanovic.kroontask.ui.feed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import co.vladanjovanovic.kroontask.R
import co.vladanjovanovic.kroontask.utils.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FeedFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
       = inflater.inflate(R.layout.fragment_feed, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeedViewModel::class.java)

        viewModel.fetchFeeds()

        viewModel.feeds.observe(this, Observer {
            for(feed in it){
                Log.i("LOG", feed.uid)
            }
        })
    }

}