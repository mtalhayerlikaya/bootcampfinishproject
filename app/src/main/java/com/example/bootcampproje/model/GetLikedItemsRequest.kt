package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class GetLikedItemsRequest(
    @SerializedName("username")
    val username:String
)



