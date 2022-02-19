package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("success")
    val success:Int,
    @SerializedName("message")
    val message:String


)
