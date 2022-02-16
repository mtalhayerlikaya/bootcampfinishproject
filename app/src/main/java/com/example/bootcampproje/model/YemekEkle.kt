package com.example.bootcampproje.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class YemekEkle(
    @SerializedName("yemek_adi")
    val yemek_adi:String,
    @SerializedName("yemek_resim_adi")
    val yemek_resim_adi:String,
    @SerializedName("yemek_fiyat")
    val yemek_fiyat:Int,
    @SerializedName("yemek_siparis_adet")
    val yemek_siparis_adet:Int,
    @SerializedName("kullanici_adi")
    val kullanici_adi:String


)
