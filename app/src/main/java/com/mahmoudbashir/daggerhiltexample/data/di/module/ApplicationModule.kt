package com.mahmoudbashir.daggerhiltexample.data.di.module

import com.mahmoudbashir.daggerhiltexample.data.api.ApiHelper
import com.mahmoudbashir.daggerhiltexample.data.api.ApiHelperImpl
import com.mahmoudbashir.daggerhiltexample.data.api.ApiService
import com.mahmoudbashir.daggerhiltexample.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //todo  This means that the dependencies provided here will be used across the application
//@InstallIn(ActivityComponent::class) //todo  Let's consider that we want to use at the activity level
object ApplicationModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient,BASE_URL:String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl) :ApiHelper = apiHelper
}