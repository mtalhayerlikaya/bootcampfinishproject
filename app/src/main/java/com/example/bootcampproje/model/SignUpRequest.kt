package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("username")
    val username:String,
    @SerializedName("password")
    val password:String

)
