package co.vladanjovanovic.kroontask.ui.feed

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import co.vladanjovanovic.kroontask.R
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.data.model.FeedType
import co.vladanjovanovic.kroontask.ui.feed.viewholders.ImageItemViewHolder
import co.vladanjovanovic.kroontask.ui.feed.viewholders.TextItemViewHolder

class FeedAdapter(val f: Fragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: ArrayList<Feed> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> TextItemViewHolder(f.layoutInflater.inflate(R.layout.item_feed_textitem, parent, false))
            1 -> ImageItemViewHolder(f.layoutInflater.inflate(R.layout.item_feed_imageitem, parent, false))
            else -> TextItemViewHolder(f.layoutInflater.inflate(R.layout.item_feed_textitem, parent, false))
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as TextItemViewHolder).bind(list[position])
            1 -> (holder as ImageItemViewHolder).bind(list[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            FeedType.TEXTITEM -> 0
            FeedType.IMAGEITEM -> 1
        }
    }

    fun submitList(list: ArrayList<Feed>) {
        this.list = list
        notifyDataSetChanged()
    }

}