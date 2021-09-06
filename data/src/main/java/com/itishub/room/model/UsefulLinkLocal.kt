package com.itishub.room.model

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    primaryKeys = ["title", "url"],
    foreignKeys = [ForeignKey(
        entity = LessonLocal::class,
        parentColumns = ["id"],
        childColumns = ["lessonId"]
    )]
)
data class UsefulLinkLocal(
    var title: String,
    var url: String,
    var lessonId: Int
)