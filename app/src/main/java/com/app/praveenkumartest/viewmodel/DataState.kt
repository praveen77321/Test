package com.app.praveenkumartest.viewmodels

import com.app.praveenkumartest.service.model.NY_Data

sealed class DataState {
    class Success(val DataItem: NY_Data) : DataState()
    class Error(val message: String?) : DataState()
}