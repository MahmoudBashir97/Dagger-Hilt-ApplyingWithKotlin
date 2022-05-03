package com.mahmoudbashir.daggerhiltexample.data.api

import com.mahmoudbashir.daggerhiltexample.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}