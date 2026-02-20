package com.useranonimo.myapplication.data

import com.google.gson.annotations.SerializedName
data class UrlResponse(
    val alias: String,

    @SerializedName("_links")
    val links: Links
)

data class Links(
    val self: String,
    val short: String
)
