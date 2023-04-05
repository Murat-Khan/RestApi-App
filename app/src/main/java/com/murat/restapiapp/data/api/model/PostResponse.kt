package com.murat.restapiapp.data.api.model

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("userId")
    var userId: Long? = null,
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("body")
    var body: String? = null,
)
