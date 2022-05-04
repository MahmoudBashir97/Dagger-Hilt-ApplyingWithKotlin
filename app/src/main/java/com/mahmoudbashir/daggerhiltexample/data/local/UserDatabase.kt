package com.mahmoudbashir.daggerhiltexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahmoudbashir.daggerhiltexample.data.model.UserLocalModel


@Database(entities = [UserLocalModel::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    abstract fun dao():UserDao

    companion object{
        val DATABASE_NAME: String = "users_db"
    }
}