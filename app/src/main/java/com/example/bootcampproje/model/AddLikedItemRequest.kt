package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class AddLikedItemRequest(
    @SerializedName("username")
    val username:String,
    @SerializedName("item")
    val item:String

)
