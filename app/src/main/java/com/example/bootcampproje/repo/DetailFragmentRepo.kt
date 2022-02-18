package com.example.bootcampproje.repo

import com.example.bootcampproje.api.ApiUtils
import com.example.bootcampproje.api.RetrofitApi
import com.example.bootcampproje.model.AddLikedItemRequest
import com.example.bootcampproje.model.YemekEkle
import javax.inject.Inject

class DetailFragmentRepo
@Inject
constructor(val api:RetrofitApi) {
    private var likeDao = ApiUtils.getKisilerDaoInterface()


    suspend fun sendAddToBasketRequest(yemek:YemekEkle){
        api.sendAddRequest(yemek.yemek_adi,
            yemek.yemek_resim_adi,
            yemek.yemek_fiyat,yemek.yemek_siparis_adet,yemek.kullanici_adi)
    }

    suspend fun addLikedItemsToServer(like: AddLikedItemRequest){
        likeDao.addLikedItems(like)
    }



}