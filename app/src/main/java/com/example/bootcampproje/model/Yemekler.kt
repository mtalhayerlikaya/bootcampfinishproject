package com.example.bootcampproje.model

import com.google.gson.annotations.SerializedName

data class Yemekler(
    @SerializedName("yemekler")
    var yemekler:List<Yemek>
)
