package com.example.bootcampproje.repo

import androidx.lifecycle.MutableLiveData
import com.example.bootcampproje.RoomDB.RoomDB
import com.example.bootcampproje.api.ApiUtils
import com.example.bootcampproje.model.GetLikedItemsRequest
import com.example.bootcampproje.model.GetLikedItemsResponse
import com.example.bootcampproje.model.YemekAlResponse
import javax.inject.Inject

class LikeRepo {

    private var likedItemList = MutableLiveData<GetLikedItemsResponse>()

    private var likeDao = ApiUtils.getKisilerDaoInterface()

    fun returnLikedList(): MutableLiveData<GetLikedItemsResponse> {
        return likedItemList
    }

    suspend fun getLikedItemsFromServer(){
        val likedItem = GetLikedItemsRequest("ecykk")
        val response = likeDao.getLikedItems(likedItem)

        if(response.isSuccessful){
           response.body()?.let {
               likedItemList.value = it
           }
        }
    }


}