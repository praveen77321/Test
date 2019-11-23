package com.app.praveenkumartest

import android.app.Application
import com.app.praveenkumartest.di.AppModule
import com.app.praveenkumartest.di.DaggerDataComponent
import com.app.praveenkumartest.di.DataComponent


class PraveenTestApplication : Application() {

    companion object {
        lateinit var dataComponent: DataComponent
    }

    override fun onCreate() {
        super.onCreate()
        dataComponent = DaggerDataComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}