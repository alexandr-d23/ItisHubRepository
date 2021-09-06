package com.itishub.interfaces

import com.itishub.model.Creator
import io.reactivex.Completable
import io.reactivex.Observable

interface CreatorRepository {

    fun getCreators(): Observable<List<Creator>>

    fun updateCreators(): Completable
}