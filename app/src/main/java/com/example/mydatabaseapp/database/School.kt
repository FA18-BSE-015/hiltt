package com.example.mydatabaseapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School(
    @PrimaryKey(autoGenerate = false)


    //@ColumnInfo(name = "name")
    var name: String
/**

    @ColumnInfo(name = "father_name")
    var fatherName: String,

    @ColumnInfo(name = "age")
    var age: Int,

    @ColumnInfo(name= "roll_no")
    val rollNo: Int

)**/
)