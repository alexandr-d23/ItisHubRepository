package com.itishub.retrofit

import com.itishub.retrofit.entities.SubjectResponse
import com.itishub.retrofit.entities.CreatorResponse
import com.itishub.retrofit.entities.LessonResponse
import com.itishub.retrofit.entities.ReviewRequest
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ContentService {

    @GET("creators")
    fun getCreators(): Single<List<CreatorResponse>>

    @GET("courses")
    fun getSubjects(): Single<List<SubjectResponse>>

    fun getLessons(): Single<List<LessonResponse>>

    @Headers("Content-Type: application/json")
    @POST("review")
    fun sendReview(@Body review: ReviewRequest): Single<ResponseBody>

}