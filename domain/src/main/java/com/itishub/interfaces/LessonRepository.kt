package com.itishub.interfaces

import com.itishub.model.Lesson
import io.reactivex.Completable
import io.reactivex.Single

interface LessonRepository {

    fun updateLessons(): Completable

    fun getLessonById(id: Int): Single<Lesson>
}