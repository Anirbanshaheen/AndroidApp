package com.example.androidapp.room.dao

import androidx.room.*
import com.example.androidapp.room.entities.Director
import com.example.androidapp.room.entities.School
import com.example.androidapp.room.entities.Student
import com.example.androidapp.room.entities.Subject
import com.example.androidapp.room.entities.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // "suspend fun" Execute background thread
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction // @Transaction for thread safe
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>
}