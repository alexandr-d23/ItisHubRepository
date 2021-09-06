package com.itishub.interfaces

import com.itishub.model.Subject
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface SubjectRepository {

    fun getSubjects(): Observable<List<Subject>>

    fun updateSubjects(): Completable

    fun getSubjectWithLesson(id: Int): Single<Subject>
}