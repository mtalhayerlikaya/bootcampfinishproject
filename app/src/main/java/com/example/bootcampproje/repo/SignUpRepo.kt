package com.example.bootcampproje.repo

import androidx.lifecycle.MutableLiveData
import com.example.bootcampproje.api.ApiUtils
import com.example.bootcampproje.model.LoginRequest
import com.example.bootcampproje.model.LoginResponse
import com.example.bootcampproje.model.SignUpRequest
import com.example.bootcampproje.model.SignUpResponse
import javax.inject.Inject

class SignUpRepo
@Inject
constructor(){

    private var signUpDao = ApiUtils.getInterfaceLoginAndSignUp()

    val signUpRepoLivedata = MutableLiveData<SignUpResponse?>()



    fun returnSignUpLiveData(): MutableLiveData<SignUpResponse?> {
        return signUpRepoLivedata
    }

    suspend fun sendSignUpReq(request: SignUpRequest){
        val response = signUpDao.signUpRequest(request)

        if(response.isSuccessful){
            response.body()?.let {
                signUpRepoLivedata.value = it
            }
        }


    }






}