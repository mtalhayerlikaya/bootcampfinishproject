package com.example.bootcampproje.repo

import androidx.lifecycle.MutableLiveData
import com.example.bootcampproje.api.RetrofitApi
import com.example.bootcampproje.model.YemekAlResponse
import com.example.bootcampproje.model.Yemekler
import javax.inject.Inject

class BasketFragmentRepo
@Inject
constructor(val api:RetrofitApi) {

    private var basketList = MutableLiveData<YemekAlResponse>()

    fun returnBasketList(): MutableLiveData<YemekAlResponse> {
        return basketList
    }

    suspend fun getDataFromServer(kullanici_adi:String){
        val response = api.getFoodOnBasket(kullanici_adi)

        try {
            if(response.isSuccessful){
                response.body()?.let {
                    basketList.value = it
                }
            }
        }catch(e:Exception){
            e.printStackTrace()
        }


    }

}