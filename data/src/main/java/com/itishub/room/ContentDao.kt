package com.itishub.room

import androidx.room.*
import com.itishub.room.model.CreatorLocal
import com.itishub.room.model.LessonLocal
import com.itishub.room.model.SubjectLocal
import com.itishub.room.model.UsefulLinkLocal
import com.itishub.room.relations.LessonWithLinks
import com.itishub.room.relations.SubjectWithLessons
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCreators(list: List<CreatorLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSubjects(subjects: List<SubjectLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLessons(lessons: List<LessonLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLinks(links: List<UsefulLinkLocal>)

    @Query("SELECT * FROM CreatorLocal")
    fun getCreators(): Observable<List<CreatorLocal>>

    @Query("SELECT * FROM SubjectLocal")
    fun getSubjects(): Observable<List<SubjectLocal>>

    @Transaction
    @Query("SELECT * FROM SubjectLocal WHERE id = :id LIMIT 1")
    fun getSubjectWithLessons(id: Int): Single<SubjectWithLessons>

    @Transaction
    @Query("SELECT * FROM LessonLocal WHERE id = :id LIMIT 1")
    fun getLessonWithLinks(id: Int): Single<LessonWithLinks>

}