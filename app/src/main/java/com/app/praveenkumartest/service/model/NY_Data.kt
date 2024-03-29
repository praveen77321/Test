package com.app.praveenkumartest.service.model


import com.google.gson.annotations.SerializedName

data class NY_Data(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("status")
    val status: String?
)