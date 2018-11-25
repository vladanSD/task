package co.vladanjovanovic.kroontask.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import co.vladanjovanovic.kroontask.R
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.utils.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class FeedFragment : DaggerFragment(), SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_feed, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeedViewModel::class.java)

        initViews()
        viewModel.feeds.observe(this, Observer {
            (list.adapter as FeedAdapter).submitList(it as ArrayList<Feed>)
            swipe.isRefreshing = false
        })

        viewModel.networkError.observe(this, Observer {
            if (it.message != null)
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                swipe.isRefreshing = false
        })

        swipe.setOnRefreshListener(this)

        viewModel.getFeeds()
    }

    private fun initViews() {
        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = FeedAdapter(this)
        list.hasFixedSize()
    }

    override fun onRefresh() {
        viewModel.getFeeds()
    }

}