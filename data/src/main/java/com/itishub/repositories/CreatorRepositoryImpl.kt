package com.itishub.repositories

import com.itishub.interfaces.CreatorRepository
import com.itishub.model.Creator
import com.itishub.retrofit.ContentService
import com.itishub.room.ContentDao
import com.itishub.room.model.CreatorLocal
import com.itishub.utils.Converter
import io.reactivex.Completable
import io.reactivex.Observable

class CreatorRepositoryImpl(
    private val contentService: ContentService,
    private val contentDao: ContentDao
) : CreatorRepository {

    override fun getCreators(): Observable<List<Creator>> = contentDao.getCreators().map {
        it.map(CreatorLocal::toCreatorDomain)
    }

    override fun updateCreators(): Completable {
        return contentService.getCreators().map { list ->
            Converter.getCreatorsFromResponse(list)
        }.doOnEvent { list, _ ->
            contentDao.insertCreators(list)
        }.ignoreElement()
    }


}