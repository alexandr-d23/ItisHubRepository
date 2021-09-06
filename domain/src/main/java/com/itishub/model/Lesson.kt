package com.itishub.model

data class Lesson(
    var id: Int = 0,
    var description: String = "",
    var pdfFile: String = "",
    var title: String = "",
    var videoUrl: String = "",
    var subjectId: Int = 0,
    var links: List<UsefulLink> = listOf()
) {
    fun getYoutubeId(): String = videoUrl.split('/').last()
}
