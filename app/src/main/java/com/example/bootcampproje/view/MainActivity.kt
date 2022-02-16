package com.example.bootcampproje.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bootcampproje.R
import com.example.bootcampproje.api.RetrofitApi
import com.example.bootcampproje.util.URL
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.IO+ Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)
        bottomNavigationView.setupWithNavController(navController)

        handleBottomNavBar()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)

        /*scope.launch {
            retrofit.sendAddRequest("Baklava","baklava.png",3,3,"mtalhayerlikaya")

        }*/
        /*scope.launch {
            retrofit.getFoodOnBasket("mtalhayerlikaya")

        }
        scope.launch {
            getData()
        }

*/

    }

    suspend fun getData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)

        val response = retrofit.getFoodOnBasket("mtalhayerlikaya")
        if(response.isSuccessful){
            response.body()?.let {
                it.sepet_yemekler.forEach {
                    println(it)
                }
            }
        }
    }



    private fun handleBottomNavBar(){
        //bottom_navigation_menu.visibility = View.GONE

        supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {

            override fun onFragmentViewCreated(
                fm: FragmentManager,
                f: Fragment,
                v: View,
                savedInstanceState: Bundle?
            ) {
                super.onFragmentViewCreated(fm, f, v, savedInstanceState)

                when (f) {
                    is BasketFragment -> bottomNavigationView.visibility = View.GONE
                    is DetailFragment->bottomNavigationView.visibility = View.GONE
                    else -> bottomNavigationView.visibility = View.VISIBLE

                }

            }

        }, true)
    }



}