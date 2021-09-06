package com.itishub.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.itishub.room.model.CreatorLocal
import com.itishub.room.model.LessonLocal
import com.itishub.room.model.SubjectLocal
import com.itishub.room.model.UsefulLinkLocal

@Database(
    entities = [
        CreatorLocal::class,
        SubjectLocal::class,
        LessonLocal::class,
        UsefulLinkLocal::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {
    abstract val contentDao: ContentDao

    companion object {
        @Volatile
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            return instance ?: Room.databaseBuilder(
                context,
                MyDatabase::class.java,
                "db"
            ).build().also {
                instance = it
            }
        }
    }

}