package com.example.androidapp.room.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidapp.room.entities.School
import com.example.androidapp.room.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School, // Who contains multiple instance, that table will be @Embedded
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student> // For Many students

)
