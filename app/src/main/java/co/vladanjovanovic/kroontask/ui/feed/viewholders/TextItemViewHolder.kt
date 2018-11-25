package co.vladanjovanovic.kroontask.ui.feed.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.vladanjovanovic.kroontask.R
import co.vladanjovanovic.kroontask.data.model.Feed
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_feed_textitem.*

class TextItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer,
    View.OnClickListener {

    lateinit var feed: Feed

    init {
        button_like.setOnClickListener(this)
    }

    fun bind(item: Feed) {
        feed = item
        text_name.text = feed.authorName
        text_message.text = feed.message
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_like -> {
                //do something
            }
        }
    }
}