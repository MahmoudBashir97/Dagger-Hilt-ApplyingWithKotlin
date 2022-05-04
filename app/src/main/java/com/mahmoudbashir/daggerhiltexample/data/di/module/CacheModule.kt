package com.mahmoudbashir.daggerhiltexample.data.di.module

import android.content.Context
import androidx.room.Room
import com.mahmoudbashir.daggerhiltexample.data.local.UserDao
import com.mahmoudbashir.daggerhiltexample.data.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun providerUserDatabase(@ApplicationContext context:Context):UserDatabase{
        return Room.databaseBuilder(context,
            UserDatabase::class.java,
            UserDatabase.DATABASE_NAME
            ).fallbackToDestructiveMigration()
             .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDatabase:UserDatabase):UserDao{
        return userDatabase.dao()
    }
}