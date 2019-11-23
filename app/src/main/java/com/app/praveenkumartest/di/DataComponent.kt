package com.app.praveenkumartest.di

import com.app.praveenkumartest.view.ui.DataListFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class])
interface DataComponent {
    fun inject(dataListFragment: DataListFragment)

}