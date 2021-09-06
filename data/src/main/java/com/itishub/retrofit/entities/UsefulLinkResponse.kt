package com.itishub.retrofit.entities

import com.google.gson.annotations.SerializedName
import com.itishub.room.model.UsefulLinkLocal

data class UsefulLinkResponse(
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String
)

fun UsefulLinkResponse.toUsefulLinkLocal(lessonId: Int): UsefulLinkLocal =
    UsefulLinkLocal(
        title = this.title,
        url = this.url,
        lessonId = lessonId
    )