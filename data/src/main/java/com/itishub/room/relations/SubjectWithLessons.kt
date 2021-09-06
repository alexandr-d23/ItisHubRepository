package com.itishub.room.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.itishub.model.Subject
import com.itishub.room.model.LessonLocal
import com.itishub.room.model.SubjectLocal
import com.itishub.room.model.toLessonDomain

data class SubjectWithLessons(
    @Embedded
    var subject: SubjectLocal,
    @Relation(parentColumn = "id", entityColumn = "subjectId", entity = LessonLocal::class)
    var lessons: List<LessonLocal>
)

fun SubjectWithLessons.toDomainSubjects(): Subject {
    val subject = this.subject
    return Subject(
        id = subject.id,
        title = subject.title,
        url = subject.url,
        lessonsCount = this.lessons.size,
        image = subject.image,
        lessons = this.lessons.map(LessonLocal::toLessonDomain)
    )
}