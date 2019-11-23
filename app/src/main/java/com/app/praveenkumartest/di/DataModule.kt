package com.app.praveenkumartest.di

import com.app.praveenkumartest.service.repository.DataAPI
import com.app.praveenkumartest.service.repository.DataRestAPI
import com.app.praveenkumartest.service.repository.APIRequest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideNewsAPI(APIRequest: APIRequest): DataAPI = DataRestAPI(APIRequest)

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): APIRequest = retrofit.create(APIRequest::class.java)

}
