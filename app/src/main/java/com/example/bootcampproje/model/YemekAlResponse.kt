package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class YemekAlResponse(
    @SerializedName("sepet_yemekler")
    val sepet_yemekler:List<SepetYemek>

)