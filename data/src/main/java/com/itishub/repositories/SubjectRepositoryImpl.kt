package com.itishub.repositories

import com.itishub.interfaces.SubjectRepository
import com.itishub.model.Subject
import com.itishub.retrofit.ContentService
import com.itishub.retrofit.entities.SubjectResponse
import com.itishub.retrofit.entities.toLocalSubject
import com.itishub.room.ContentDao
import com.itishub.room.model.SubjectLocal
import com.itishub.room.model.toDomainSubject
import com.itishub.room.relations.SubjectWithLessons
import com.itishub.room.relations.toDomainSubjects
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class SubjectRepositoryImpl(
    private val contentService: ContentService,
    private val contentDao: ContentDao
) : SubjectRepository {

    override fun getSubjects(): Observable<List<Subject>> = contentDao.getSubjects().map {
        it.map(SubjectLocal::toDomainSubject)
    }

    override fun updateSubjects(): Completable {
        return contentService.getSubjects()
            .map { list ->
                list.map(SubjectResponse::toLocalSubject)
            }
            .doOnEvent { subjects, _ ->
                contentDao.insertSubjects(subjects)
            }.ignoreElement()
    }

    override fun getSubjectWithLesson(id: Int): Single<Subject> =
        contentDao.getSubjectWithLessons(id).map(SubjectWithLessons::toDomainSubjects)
}