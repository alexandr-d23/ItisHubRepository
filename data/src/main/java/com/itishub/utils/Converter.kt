package com.itishub.utils

import com.itishub.retrofit.entities.SubjectResponse
import com.itishub.retrofit.entities.CreatorResponse
import com.itishub.room.model.CreatorLocal
import com.itishub.room.model.LessonLocal
import com.itishub.room.model.SubjectLocal
import com.itishub.room.model.UsefulLinkLocal

class Converter {
    companion object {

        fun getCreatorsFromResponse(list: List<CreatorResponse>): List<CreatorLocal> =
            list.map { creatorResponse ->
                CreatorLocal(
                    id = creatorResponse.id,
                    avatar = creatorResponse.avatar,
                    about = creatorResponse.about,
                    name = creatorResponse.name,
                    github = creatorResponse.github,
                    surname = creatorResponse.surname,
                    telegram = creatorResponse.telegram,
                    vk = creatorResponse.vk
                )
            }
    }
}