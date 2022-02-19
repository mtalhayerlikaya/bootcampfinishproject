package com.example.bootcampproje.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcampproje.model.SepetYemek
import com.example.bootcampproje.model.YemekAlResponse
import com.example.bootcampproje.model.YemekEkle
import com.example.bootcampproje.model.Yemekler
import com.example.bootcampproje.repo.BasketFragmentRepo
import com.example.bootcampproje.util.Singleton
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

    fun addTobasket(yemekEkle: YemekEkle)= viewModelScope.launch{
        repo.addToBasketRequest(yemekEkle)
    }

    fun loadBasketList()=viewModelScope.launch{
        repo.getDataFromServer()
    }

    fun deleteFood(yemek_sep_id:Int)=viewModelScope.launch{
        repo.deleteFood(yemek_sep_id)
    }

    fun checkIfExistInBasket(list:List<SepetYemek>):MutableList<SepetYemek>{
        var hashMap = hashMapOf<String,SepetYemek>()
        var foodStrList = mutableListOf<String>()

        list.forEach {
            foodStrList.add(it.yemek_adi)
        }

        foodStrList.forEachIndexed{ index, element->
            hashMap[element] = list[index].copy(list[index].sepet_yemek_id,
                list[index].yemek_adi,
                list[index].yemek_resim_adi,
                list[index].yemek_fiyat,
                0,
                list[index].kullanici_adi)
        }

        foodStrList.forEachIndexed{ index, element->
            hashMap[element]!!.yemek_siparis_adet += list[index].yemek_siparis_adet
        }

        return hashMap.values.toMutableList()
    }

}