package com.itishub.retrofit.entities

import com.google.gson.annotations.SerializedName
import com.itishub.model.Subject
import com.itishub.room.model.SubjectLocal

data class SubjectResponse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("lessons")
    var lessons: List<LessonResponse>,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("image")
    var image: String?
)

fun SubjectResponse.toLocalSubject(): SubjectLocal = SubjectLocal(
    id = this.id,
    title = this.title,
    url = this.url,
    lessonsCount = this.lessons.size,
    image = this.image
)