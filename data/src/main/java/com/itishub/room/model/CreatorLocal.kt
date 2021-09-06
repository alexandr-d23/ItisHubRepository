package com.itishub.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.itishub.model.Creator

@Entity
data class CreatorLocal(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var about: String,
    var avatar: String,
    var github: String,
    var name: String,
    var surname: String,
    var telegram: String,
    var vk: String
)

fun Creator.toCreatorDomain(): Creator =
    Creator(
        id = this.id,
        about = this.about,
        avatar = this.avatar,
        github = this.github,
        name = this.name,
        surname = this.surname,
        telegram = this.telegram,
        vk = this.vk
    )