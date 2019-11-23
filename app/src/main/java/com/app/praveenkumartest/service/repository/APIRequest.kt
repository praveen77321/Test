package com.app.praveenkumartest.service.repository


import com.app.praveenkumartest.service.model.NY_Data
import retrofit2.http.GET
import retrofit2.http.Query

interface  APIRequest {
    @GET("http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?")
    suspend fun getDeferredTop(@Query("api-key") api_key: String): NY_Data
}