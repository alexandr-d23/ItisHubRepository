package com.itishub.room.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.itishub.model.Subject

@Entity
data class SubjectLocal(
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    var title: String = "",
    var url: String = "",
    var lessonsCount: Int = 0,
    var image: String? = null,
)

fun SubjectLocal.toDomainSubject(): Subject =
    Subject(
        id = this.id,
        title = this.title,
        url = this.url,
        lessonsCount = this.lessonsCount,
        image = this.image
    )