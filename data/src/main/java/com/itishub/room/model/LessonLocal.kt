package com.itishub.room.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.itishub.model.Lesson

@Entity(
    foreignKeys = [ForeignKey(
        entity = SubjectLocal::class,
        parentColumns = ["id"],
        childColumns = ["subjectId"]
    )]
)
data class LessonLocal(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val description: String = "",
    val pdfFile: String = "",
    val title: String = "",
    val videoUrl: String = "",
    val subjectId: Int = 0,
    @Ignore
    val links: List<UsefulLinkLocal>
)

fun LessonLocal.toLessonDomain(): Lesson =
    Lesson(
        id = this.id,
        videoUrl = this.videoUrl,
        title = this.title,
        description = this.description,
        pdfFile = this.pdfFile,
        subjectId = this.id,
    )