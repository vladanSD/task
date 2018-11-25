package co.vladanjovanovic.kroontask.ui.feed.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.vladanjovanovic.kroontask.R
import co.vladanjovanovic.kroontask.data.model.Feed
import co.vladanjovanovic.kroontask.utils.DateDifference
import co.vladanjovanovic.kroontask.utils.KroonGlide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
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
        text_creation_time.text = DateDifference.getDifference(feed.creationTime, itemView.context)

        KroonGlide
            .with(itemView.context)
            .load(feed.authorAvatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.background_placeholder)
            .into(image_avatar)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_like -> {
                //do something
            }
        }
    }
}