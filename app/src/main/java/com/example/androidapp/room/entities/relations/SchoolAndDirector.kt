package com.example.androidapp.room.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidapp.room.entities.Director
import com.example.androidapp.room.entities.School

data class SchoolAndDirector(
    /**
     * @Embedded means, All the fields of school table are inserted in this class Only internally in ROOM
     * Who contains multiple instance, that table will be @Embedded
     */
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
