package com.mahmoudbashir.daggerhiltexample.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class UserLocalModel (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name:String,
    val age:Int,
    val nationality:String
)
