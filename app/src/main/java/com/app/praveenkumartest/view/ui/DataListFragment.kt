package com.app.praveenkumartest.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.praveenkumartest.PraveenTestApplication
import com.app.praveenkumartest.R
import com.app.praveenkumartest.service.model.NY_Data
import com.app.praveenkumartest.service.model.Result
import com.app.praveenkumartest.utils.ViewModelFactory
import com.app.praveenkumartest.utils.extensions.androidLazy
import com.app.praveenkumartest.utils.extensions.getViewModel
import com.app.praveenkumartest.utils.extensions.inflate
import com.app.praveenkumartest.view.adapter.NewsAdapter
import com.app.praveenkumartest.view.adapter.NewsDelegateAdapter
import com.app.praveenkumartest.viewmodels.NY_ViewModel
import com.app.praveenkumartest.viewmodels.DataState
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.news_fragment.*
import javax.inject.Inject

class DataListFragment(twoPane: Boolean) : Fragment(), NewsDelegateAdapter.onViewSelectedListener {


    var twoPane: Boolean = false

    init {
        this.twoPane = twoPane
    }

    override fun onItemSelected(result: Result?) {
        if (twoPane) {
            val fragment = DataDetailFragment()
                .apply {
                    arguments = Bundle().apply {
                         putString(DataDetailFragment.ARG_ITEM_ID, result!!.title)
                    }
                }
            fragmentManager!!
                .beginTransaction()
                .replace(R.id.item_detail_container, fragment)
                .commit()
        } else {
            val intent = Intent(context, DataDetailActivity::class.java).apply {
                putExtra(DataDetailFragment.ARG_ITEM_ID, result!!.title)
            }
            startActivity(intent)
        }


    }


    private var redditNews: NY_Data? = null
    private val newsAdapter by androidLazy { NewsAdapter(this) }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<NY_ViewModel>
    private val newsViewModel by androidLazy {
        getViewModel<NY_ViewModel>(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PraveenTestApplication.dataComponent.inject(this)

        newsViewModel.newsState.observe(this, Observer<DataState> {
            manageState(it)
        })
    }

    private fun manageState(kedditState: DataState?) {
        val state = kedditState ?: return
        when (state) {
            is DataState.Success -> {
                redditNews = state.DataItem
                newsAdapter.addNews(redditNews!!.results as List<Result>)
            }
            is DataState.Error -> {
                Snackbar.make(news_list, state.message.orEmpty(), Snackbar.LENGTH_INDEFINITE)
                    .setAction("RETRY") { requestNews() }
                    .show()
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
        }
        news_list.adapter = newsAdapter

        requestNews()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val news = newsAdapter.getNews()

    }

    private fun requestNews() {
        /**
         * first time will send empty string for 'after' parameter.
         * Next time we will have redditNews set with the next page to
         * navigate with the 'after' param.
         */
        newsViewModel.fetchNews("KZgy6KDG11K5T7WBKWZZWUG8GcyIqhCd")
    }
}

