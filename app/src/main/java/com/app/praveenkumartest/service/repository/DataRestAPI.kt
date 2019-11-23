package com.app.praveenkumartest.service.repository


import com.app.praveenkumartest.service.model.NY_Data
import javax.inject.Inject

class DataRestAPI @Inject constructor(private val APIRequest: APIRequest) : DataAPI {

    override suspend fun getNYNews(after: String): NY_Data {
        return APIRequest.getDeferredTop(after)

    }



}