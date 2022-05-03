package com.mahmoudbashir.daggerhiltexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.daggerhiltexample.data.model.User
import com.mahmoudbashir.daggerhiltexample.data.repository.MainRepository
import com.mahmoudbashir.daggerhiltexample.utils.NetworkHelper
import com.mahmoudbashir.daggerhiltexample.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo : MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel(){

    private val _users :MutableLiveData<Resource<List<User>>> = MutableLiveData()

    val users: LiveData<Resource<List<User>>> get() = _users

    init {
        fetchData()
    }

    fun fetchData(){
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                repo.getUsers().let {
                    if (it.isSuccessful){
                        _users.postValue(Resource.success(it.body()))
                    }else _users.postValue(Resource.error(it.errorBody().toString(),null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))

        }
    }

}