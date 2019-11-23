package com.app.praveenkumartest.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.praveenkumartest.R
import com.app.praveenkumartest.service.model.Result
import com.app.praveenkumartest.utils.ViewType
import com.app.praveenkumartest.utils.ViewTypeDelegateAdapter
import com.app.praveenkumartest.utils.extensions.inflate
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter(val viewActions: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(result: Result?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as Result)
    }

    inner class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        private val imgThumbnail = itemView.img_news
        private val title = itemView.title
        private val author = itemView.author
        private val time = itemView.time

        fun bind(item: Result) {
            title.text = item.title
            author.text = item.byline
            time.text = item.publishedDate

            super.itemView.setOnClickListener { viewActions.onItemSelected(item)}
        }
    }
}