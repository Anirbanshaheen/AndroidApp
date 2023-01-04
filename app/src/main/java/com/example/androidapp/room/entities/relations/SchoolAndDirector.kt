package com.example.androidapp.room.entities.relations

import androidx.room.Embedded
import com.example.androidapp.room.entities.Director
import com.example.androidapp.room.entities.School

data class SchoolAndDirector(
    @Embedded val school: School, // @Embedded means, All the fields of school table are inserted in this class Only internally in ROOM
    val director: Director
)
