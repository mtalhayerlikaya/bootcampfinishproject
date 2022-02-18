package com.example.bootcampproje.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcampproje.model.AddLikedItemRequest
import com.example.bootcampproje.model.YemekEkle
import com.example.bootcampproje.repo.DetailFragmentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(val repo:DetailFragmentRepo):ViewModel() {

       fun addTobasket(yemekEkle: YemekEkle)= viewModelScope.launch{
            repo.sendAddToBasketRequest(yemekEkle)
        }

    fun addLikedItems(like: AddLikedItemRequest)=viewModelScope.launch{
        repo.addLikedItemsToServer(like)
    }

}