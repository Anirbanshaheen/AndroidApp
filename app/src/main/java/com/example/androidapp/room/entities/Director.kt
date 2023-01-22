package com.example.androidapp.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director (
    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolName: String  // As it is "one to one" relation so we can put "schoolName" here, also we can put "directorName" in School Data Class
)