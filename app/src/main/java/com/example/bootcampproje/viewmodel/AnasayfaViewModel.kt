package com.example.bootcampproje.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcampproje.model.Yemekler
import com.example.bootcampproje.repo.HomeFragmentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel
@Inject
constructor(
    var repo: HomeFragmentRepo
) : ViewModel() {


    private var yemeklerList = MutableLiveData<Yemekler>()
    val yemeklerLiveData : LiveData<Yemekler>
        get() = yemeklerList

    init {
        loadData()
        yemeklerList = repo.getYemekList()
    }


    fun loadData()=viewModelScope.launch{
        repo.getData()
    }



}