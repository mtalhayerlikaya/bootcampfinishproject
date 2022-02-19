package com.example.bootcampproje.util

import com.example.bootcampproje.model.Yemek
import com.example.bootcampproje.model.Yemekler

object Singleton {
     var allFoodsSingleton : List<Yemek>?=null
     var likedFoodsSingleton : ArrayList<Yemek>?=null
     var singletonUsername:String?=null
    // lateinit var allFoodsSingleton : List<Yemek>
}