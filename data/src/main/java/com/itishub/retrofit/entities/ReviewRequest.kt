package com.itishub.retrofit.entities

import com.google.gson.annotations.SerializedName

data class ReviewRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("text")
    var text: String
)