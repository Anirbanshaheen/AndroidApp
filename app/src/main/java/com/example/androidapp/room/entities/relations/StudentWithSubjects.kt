package com.example.androidapp.room.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.androidapp.room.entities.Student
import com.example.androidapp.room.entities.Subject

/**
 * For single student get all subjects
 */
data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)