package com.mahmoudbashir.daggerhiltexample.data.repository

import com.mahmoudbashir.daggerhiltexample.data.model.UserLocalModel

interface RoomRepositoryImp {
    suspend fun insertUserModel(user:UserLocalModel):Long

    suspend fun getAllData():List<UserLocalModel>
}