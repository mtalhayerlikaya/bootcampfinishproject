package com.example.bootcampproje.api

import com.example.bootcampproje.model.*
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

    @FormUrlEncoded
    @POST("yemekler/sepettenYemekSil.php")
    suspend fun deleteRequest(@Field("kullanici_adi") kullanici_adi:String,
                              @Field("sepet_yemek_id") sepet_yemek_id:Int)


}