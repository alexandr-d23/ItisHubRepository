package com.itishub.model

data class Subject(
    var id: Int = 0,
    var title: String = "",
    var url: String = "",
    var lessonsCount: Int = 0,
    var image: String? = null,
    var lessons: List<Lesson>? = null
)