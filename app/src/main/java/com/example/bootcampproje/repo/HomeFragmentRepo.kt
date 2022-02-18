package com.example.bootcampproje.repo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.bootcampproje.api.ApiUtils
import com.example.bootcampproje.api.RetrofitApi
import com.example.bootcampproje.model.AddLikedItemRequest
import com.example.bootcampproje.model.GetLikedItemsRequest
import com.example.bootcampproje.model.Yemekler
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentRepo
@Inject
constructor(val api: RetrofitApi) {
    private var likeDao = ApiUtils.getKisilerDaoInterface()
    private var yemekList = MutableLiveData<Yemekler>()

    fun getYemekList(): MutableLiveData<Yemekler> {
        return yemekList
    }




    suspend fun addLikedItemsToServer(like: AddLikedItemRequest){
       val response = likeDao.addLikedItems(like)

        try {
            if(response.isSuccessful){
                response.body()?.let {
                    println(it)
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    suspend fun getData(){


        val response = api.getDataFromApi()

        try {
            if(response.isSuccessful){
                response.body()?.let {
                    yemekList.value = it
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }


    }

}