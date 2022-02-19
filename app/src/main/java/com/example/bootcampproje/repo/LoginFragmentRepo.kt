package com.example.bootcampproje.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bootcampproje.api.ApiUtils
import com.example.bootcampproje.model.LoginRequest
import com.example.bootcampproje.model.LoginResponse
import javax.inject.Inject

class LoginFragmentRepo
@Inject
constructor(){

    private var loginDao = ApiUtils.getInterfaceLoginAndSignUp()

    val loginRepoLivedata = MutableLiveData<LoginResponse?>()



    fun returnLiveData(): MutableLiveData<LoginResponse?> {
        return loginRepoLivedata
    }

    suspend fun sendLoginReq(request:LoginRequest){
        val response = loginDao.loginRequest(request)

        if(response.isSuccessful){
            response.body()?.let {
                loginRepoLivedata.value = it
            }
        }


    }



}