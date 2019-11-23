package com.app.praveenkumartest.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.praveenkumartest.R
import com.app.praveenkumartest.utils.ViewType
import com.app.praveenkumartest.utils.ViewTypeDelegateAdapter
import com.app.praveenkumartest.utils.extensions.inflate


class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))
}