package com.example.bootcampproje.repo

import androidx.lifecycle.MutableLiveData
import com.example.bootcampproje.api.RetrofitApi
import com.example.bootcampproje.model.YemekAlResponse
import com.example.bootcampproje.model.YemekEkle
import com.example.bootcampproje.model.Yemekler
import com.example.bootcampproje.util.Singleton
import javax.inject.Inject

class BasketFragmentRepo
@Inject
constructor(val api:RetrofitApi) {
    var a = Singleton.singletonUsername
    private var basketList = MutableLiveData<YemekAlResponse>()

    fun returnBasketList(): MutableLiveData<YemekAlResponse> {
        return basketList
    }

    suspend fun addToBasketRequest(yemek: YemekEkle){
        api.sendAddRequest(yemek.yemek_adi,
            yemek.yemek_resim_adi,
            yemek.yemek_fiyat,yemek.yemek_siparis_adet,yemek.kullanici_adi)
    }

    suspend fun deleteFood(yemek_sep_id:Int){

        api.deleteRequest(Singleton.singletonUsername!!,yemek_sep_id)
    }

    suspend fun getDataFromServer(){
        val response = api.getFoodOnBasket(Singleton.singletonUsername!!)

        try {
            if(response.isSuccessful){
                response.body()?.let {
                    basketList.value = it
                }
              /*  var it = response.body()
                    if(it != null){
                        basketList.value = it!!
                    }else{
                        basketList.value = YemekAlResponse(emptyList())
                    }*/

            }
        }catch(e:Exception){
            e.printStackTrace()
        }


    }

}