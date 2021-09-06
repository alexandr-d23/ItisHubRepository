package com.itishub.repositories

import com.itishub.interfaces.LessonRepository
import com.itishub.model.Lesson
import com.itishub.retrofit.ContentService
import com.itishub.retrofit.entities.LessonResponse
import com.itishub.retrofit.entities.toLessonlocal
import com.itishub.room.ContentDao
import io.reactivex.Completable
import io.reactivex.Single

class LessonRepositoryImpl(
    private val contentService: ContentService,
    private val contentDao: ContentDao
) : LessonRepository {

    override fun updateLessons(): Completable =
        contentService.getLessons().map { list ->
            list.map(LessonResponse::toLessonlocal)
        }.doOnEvent { lessons, _ ->
            contentDao.insertLinks(lessons.flatMap { it.links })
            contentDao.insertLessons(lessons)
        }.ignoreElement()


    override fun getLessonById(id: Int): Single<Lesson> =
        contentDao
            .getLessonWithLinks(id)
            .map {
                val l = it.lesson
                Lesson(
                    id = l.id,
                    videoUrl = l.videoUrl,
                    title = l.title,
                    description = l.description,
                    pdfFile = l.pdfFile,
                    subjectId = l.subjectId,
                )
            }
}