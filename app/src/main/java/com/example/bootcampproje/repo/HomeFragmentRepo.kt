package com.example.bootcampproje.repo

import androidx.lifecycle.MutableLiveData
import com.example.bootcampproje.api.RetrofitApi
import com.example.bootcampproje.model.Yemekler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeFragmentRepo
@Inject
constructor(val api: RetrofitApi) {

    private var yemekList = MutableLiveData<Yemekler>()



    fun getYemekList(): MutableLiveData<Yemekler> {
        return yemekList
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



/*
        val response = api.getDataFromApi()
        try {
            response.enqueue(object: Callback<Yemekler> {
                override fun onResponse(call: Call<Yemekler>, response: Response<Yemekler>) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            /*it.yemekler.forEach {
                                println(it)
                            }*/
                            yemekList.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<Yemekler>, t: Throwable) {
                    t.printStackTrace()
                }

            })

        }catch (e:Exception){
            e.printStackTrace()

        }*/
/*
       val response = api.getDataFromApi()

        try {
           if(response.isSuccessful){
               response.body()?.let {
                   return@let it
               } ?: return Yemekler(emptyList())
           }
        }catch (e:Exception){
            e.printStackTrace()
        }

       return Yemekler(emptyList())
*/
    }

}


/*
       try {
           val response = api.getDataFromApi()
           if(response.isSuccessful){
               response.body()?.let {
                   return@let it
               }
           }

       }catch (e:Exception){
           e.printStackTrace()
       }
        return Yemekler(emptyList())
*/



/*
       val response = api.getDataFromApi()
       try {
           response.enqueue(object:Callback<Yemekler>{
               override fun onResponse(call: Call<Yemekler>, response: Response<Yemekler>) {
                   if(response.isSuccessful){
                       response.body()?.let {
                           it.yemekler.forEach {
                               println(it)
                           }
                       }
                   }
               }

               override fun onFailure(call: Call<Yemekler>, t: Throwable) {
                   t.printStackTrace()
               }

           })

       }catch (e:Exception){
          e.printStackTrace()

       }
*/
