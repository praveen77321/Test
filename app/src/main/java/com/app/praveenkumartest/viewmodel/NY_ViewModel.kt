package com.app.praveenkumartest.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.praveenkumartest.service.repository.DataAPI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class NY_ViewModel @Inject constructor(
    private val api: DataAPI,
    private val coroutineContext: CoroutineContext
) : ViewModel() {

    val newsState: MutableLiveData<DataState> = MutableLiveData()

    fun fetchNews(api_key: String) = GlobalScope.launch(coroutineContext) {
        try {
            val result = api.getNYNews(api_key)
            newsState.postValue(DataState.Success(result))
        } catch (e: Throwable) {
            newsState.postValue(DataState.Error(e.message))
        }
    }

}