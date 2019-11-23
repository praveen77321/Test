package com.app.praveenkumartest.view.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.app.praveenkumartest.service.model.Result
import com.app.praveenkumartest.utils.AdapterConstants
import com.app.praveenkumartest.utils.ViewType
import com.app.praveenkumartest.utils.ViewTypeDelegateAdapter
import java.util.*

class NewsAdapter(listener: NewsDelegateAdapter.onViewSelectedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING_ITEM
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING_ITEM, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.DATA_ITEM, NewsDelegateAdapter(listener))
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun addNews(news: List<Result>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1 /* plus loading item */)
    }

    fun clearAndAddNews(news: List<Result>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        //items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getNews(): List<Result> =
            items
                .filter { it.getViewType() == AdapterConstants.DATA_ITEM }
                .map { it as Result }


    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex
}