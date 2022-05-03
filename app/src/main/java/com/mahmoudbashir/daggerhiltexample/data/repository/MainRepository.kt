package com.mahmoudbashir.daggerhiltexample.data.repository

import com.mahmoudbashir.daggerhiltexample.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}