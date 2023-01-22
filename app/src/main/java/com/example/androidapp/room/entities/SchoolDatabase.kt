package com.example.androidapp.room.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidapp.room.dao.SchoolDao
import com.example.androidapp.room.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase(){

    abstract val schoolDao: SchoolDao

    companion object {
        /**
         * when change value of INSTANCE then immediately visible to the thread and also help us to prevent RACE Condition
         */
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context) : SchoolDatabase {
            /**
             * Inside, this only execute single thread
             */
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}