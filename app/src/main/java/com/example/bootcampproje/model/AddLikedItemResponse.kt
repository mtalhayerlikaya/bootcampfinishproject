package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class AddLikedItemResponse(


    @SerializedName("success")
    val success:String,
    @SerializedName("message")
    val message:String



)
