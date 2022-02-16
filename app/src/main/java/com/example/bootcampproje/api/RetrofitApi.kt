package com.example.bootcampproje.api

import com.example.bootcampproje.model.YemekAlRequest
import com.example.bootcampproje.model.YemekAlResponse
import com.example.bootcampproje.model.YemekEkle
import com.example.bootcampproje.model.Yemekler
import retrofit2.Response
import retrofit2.http.*

interface RetrofitApi {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getDataFromApi(): Response<Yemekler>

    @FormUrlEncoded
    @POST("yemekler/sepeteYemekEkle.php")
    suspend fun sendAddRequest(
        @Field("yemek_adi")
        yemek_adi:String,
        @Field("yemek_resim_adi")
        yemek_resim_adi:String,
        @Field("yemek_fiyat")
        yemek_fiyat:Int,
        @Field("yemek_siparis_adet")
        yemek_siparis_adet:Int,
        @Field("kullanici_adi")
        kullanici_adi:String
    )

    @FormUrlEncoded
    @POST("yemekler/sepettekiYemekleriGetir.php")
    suspend fun getFoodOnBasket(@Field("kullanici_adi") kullanici_adi:String): Response<YemekAlResponse>

}