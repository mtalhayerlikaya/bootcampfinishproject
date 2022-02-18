package com.example.bootcampproje.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.bootcampproje.RoomDB.RoomDB
import com.example.bootcampproje.model.GetLikedItemsRequest
import com.example.bootcampproje.model.GetLikedItemsResponse
import com.example.bootcampproje.repo.LikeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class LikeViewModel : ViewModel() {
/*

    private var likedList_ = MutableLiveData<GetLikedItemsResponse>()
    val likedList : LiveData<GetLikedItemsResponse>
        get() =likedList_

    init {
        likedList_ = repo.returnLikedList()
        loadList()
    }

    fun loadList() = viewModelScope.launch{
        repo.getLikedItemsFromServer()
    }

*/



}