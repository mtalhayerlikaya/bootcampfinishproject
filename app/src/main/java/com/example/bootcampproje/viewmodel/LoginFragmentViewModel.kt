package com.example.bootcampproje.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcampproje.model.LoginRequest
import com.example.bootcampproje.model.LoginResponse
import com.example.bootcampproje.repo.LoginFragmentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginFragmentViewModel
@Inject
constructor(val repo: LoginFragmentRepo): ViewModel() {

    private var loginLiveData_ = MutableLiveData<LoginResponse>()
    val loginLiveData : LiveData<LoginResponse>
        get() = loginLiveData_

    init {
        loginLiveData_ = repo.returnLiveData()
    }

    fun loadRepoLiveData(req:LoginRequest)=viewModelScope.launch{
        repo.sendLoginReq(req)
    }

}