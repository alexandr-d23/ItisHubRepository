package com.itishub.room.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.itishub.room.model.LessonLocal
import com.itishub.room.model.UsefulLinkLocal


data class LessonWithLinks(
    @Embedded
    var lesson: LessonLocal,
    @Relation(parentColumn = "id", entityColumn = "lessonId")
    var links: List<UsefulLinkLocal>
)