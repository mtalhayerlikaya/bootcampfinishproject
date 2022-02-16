package com.example.bootcampproje.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcampproje.model.YemekAlResponse
import com.example.bootcampproje.model.Yemekler
import com.example.bootcampproje.repo.BasketFragmentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel
@Inject
constructor(val repo:BasketFragmentRepo):ViewModel(){
    //var kullanici_adi: String
    private var _basList = MutableLiveData<YemekAlResponse>()
    val basList : LiveData<YemekAlResponse>
        get() = _basList

    init {
        loadBasketList()
        _basList = repo.returnBasketList()
    }

    fun loadBasketList()=viewModelScope.launch{
        repo.getDataFromServer("mtalhayerlikaya")
    }


}