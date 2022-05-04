package com.mahmoudbashir.daggerhiltexample.data.repository

import com.mahmoudbashir.daggerhiltexample.data.local.UserDatabase
import com.mahmoudbashir.daggerhiltexample.data.model.UserLocalModel
import javax.inject.Inject

class LocalRepository @Inject constructor(private val userDatabase: UserDatabase):RoomRepositoryImp{
    override suspend fun insertUserModel(user: UserLocalModel): Long  = userDatabase.dao().insert(user)

    override suspend fun getAllData(): List<UserLocalModel> = userDatabase.dao().getAllUsers()
}