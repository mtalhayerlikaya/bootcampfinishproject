package com.example.bootcampproje.util

import com.example.bootcampproje.model.Yemek
import com.example.bootcampproje.model.Yemekler

object Singleton {
     var allFoodsSingleton : List<Yemek>?=null
     var likedFoodsFoodsSingleton : ArrayList<Yemek>?=null
    // lateinit var allFoodsSingleton : List<Yemek>
}