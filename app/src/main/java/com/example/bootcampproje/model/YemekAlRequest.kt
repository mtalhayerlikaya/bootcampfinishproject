package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class YemekAlRequest(
    @SerializedName("kullanici_adi")
    val kullanici_adi:String

)
