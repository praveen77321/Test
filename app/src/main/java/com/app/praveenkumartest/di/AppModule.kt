package com.app.praveenkumartest.di

import android.app.Application
import android.content.Context
import com.app.praveenkumartest.PraveenTestApplication
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.MainScope
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext


@Module
class AppModule(val app: PraveenTestApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    fun provideCoroutineContext(): CoroutineContext = Main
}
