package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class GetLikedItemsResponse(
    @SerializedName("success")
    val success:Int,
    @SerializedName("message")
    val message:List<String>


)
