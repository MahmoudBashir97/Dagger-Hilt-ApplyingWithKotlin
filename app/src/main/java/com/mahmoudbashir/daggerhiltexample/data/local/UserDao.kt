package com.mahmoudbashir.daggerhiltexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahmoudbashir.daggerhiltexample.data.model.UserLocalModel

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user:UserLocalModel) : Long


    @Query("SELECT * FROM userTable")
    suspend fun getAllUsers(): List<UserLocalModel>
}