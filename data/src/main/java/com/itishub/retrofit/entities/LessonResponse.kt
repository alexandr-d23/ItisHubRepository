package com.itishub.retrofit.entities

import com.google.gson.annotations.SerializedName
import com.itishub.room.model.LessonLocal

data class LessonResponse(
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("pdf_file")
    var pdfFile: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("useful_links")
    var usefulLinks: List<UsefulLinkResponse>,
    @SerializedName("video_url")
    var videoUrl: String
)

fun LessonResponse.toLessonlocal(): LessonLocal =
    LessonLocal(
        id = this.id,
        videoUrl = this.videoUrl,
        title = this.title,
        description = this.description,
        pdfFile = this.pdfFile,
        subjectId = this.id,
        links = this.usefulLinks.map{
            it.toUsefulLinkLocal(this.id)
        }
    )