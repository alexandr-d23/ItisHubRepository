package com.itishub.interfaces

import com.itishub.model.Review
import io.reactivex.Completable

interface ReviewRepository {

    fun sendReview(review: Review): Completable
}