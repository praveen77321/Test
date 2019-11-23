package com.app.praveenkumartest.service.model


import com.app.praveenkumartest.utils.AdapterConstants
import com.app.praveenkumartest.utils.ViewType
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("abstract")
    val `abstract`: String?,
    @SerializedName("adx_keywords")
    val adxKeywords: String?,
    @SerializedName("asset_id")
    val assetId: Long?,
    @SerializedName("byline")
    val byline: String?,
    @SerializedName("column")
    val column: Any?,
    /*@SerializedName("des_facet")
    val desFacet: List<String?>?,*/
    /*@SerializedName("geo_facet")
    val geoFacet: String?,*/
    @SerializedName("id")
    val id: Long?,
    @SerializedName("media")
    val media: List<Media?>?,
    /*@SerializedName("org_facet")
    val orgFacet: List<String?>?,*/
   /* @SerializedName("per_facet")
    val perFacet: List<String?>?,*/
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("section")
    val section: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("views")
    val views: Int?
) : ViewType {
    override fun getViewType() = AdapterConstants.DATA_ITEM
}