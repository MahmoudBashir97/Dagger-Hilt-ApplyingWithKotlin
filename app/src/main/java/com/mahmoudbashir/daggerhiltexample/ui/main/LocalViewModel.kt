package com.mahmoudbashir.daggerhiltexample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.daggerhiltexample.data.model.UserLocalModel
import com.mahmoudbashir.daggerhiltexample.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalViewModel @Inject constructor(val repo:LocalRepository):ViewModel(){

    val allData : MutableLiveData<List<UserLocalModel>> = MutableLiveData()

    fun insertUserData(user:UserLocalModel) = viewModelScope.launch {
        repo.insertUserModel(user)
    }

    fun getAllData() = viewModelScope.launch{
        allData.postValue(repo.getAllData())
    }
}