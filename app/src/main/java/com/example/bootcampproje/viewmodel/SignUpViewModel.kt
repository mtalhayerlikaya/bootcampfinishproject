package com.example.bootcampproje.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcampproje.model.SignUpRequest
import com.example.bootcampproje.model.SignUpResponse
import com.example.bootcampproje.repo.SignUpRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SignUpViewModel
@Inject
constructor(val repo:SignUpRepo)
    : ViewModel() {

    private var signUpResponse_ = MutableLiveData<SignUpResponse?>()
    val signUpResponse : LiveData<SignUpResponse?>
        get() =signUpResponse_

        init {
            signUpResponse_ = repo.returnSignUpLiveData()
        }


    fun loadSignUpRepo(req:SignUpRequest)=viewModelScope.launch{
        repo.sendSignUpReq(req)
    }

    fun clearResponse(){
        signUpResponse_.value= null
    }



}