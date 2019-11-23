package com.app.praveenkumartest.service.repository

import com.app.praveenkumartest.service.model.NY_Data

interface DataAPI {
      suspend fun getNYNews(after: String): NY_Data
}