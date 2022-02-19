package com.example.bootcampproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bootcampproje.R
import com.example.bootcampproje.adapter.HomeRecyclerViewAdapter
import com.example.bootcampproje.api.LikedDaoInterface
import com.example.bootcampproje.databinding.FragmentHomeBinding
import com.example.bootcampproje.model.GetLikedItemsRequest
import com.example.bootcampproje.util.Singleton
import com.example.bootcampproje.util.URL
import com.example.bootcampproje.viewmodel.AnasayfaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {
    val scope = CoroutineScope(Dispatchers.IO+ Job())
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("home oncreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(AnasayfaViewModel::class.java)
        scope.launch {
            getData()
        }
        println("home onViewCreated")
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object:
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }

        })
        subscribeToObserver()
    }



    fun subscribeToObserver() {
        viewModel.yemeklerLiveData.observe(viewLifecycleOwner, Observer {
            if (!it.yemekler.isEmpty()) {
                Singleton.allFoodsSingleton = it.yemekler
                val recyclerViewAdapter = HomeRecyclerViewAdapter(requireContext(),it.yemekler,viewModel)
                binding.rv.adapter = recyclerViewAdapter
                binding.rv.layoutManager = GridLayoutManager(requireContext(),2,
                    GridLayoutManager.VERTICAL,false)
                /*it.yemekler.forEach {
                    println(it)
                }*/
            } else {
                println(it.yemekler)
            }

        })
    }

    suspend fun getData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(URL.LIKED_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LikedDaoInterface::class.java)
        val like = GetLikedItemsRequest(Singleton.singletonUsername!!)
        val response = retrofit.getLikedItems(like)
        if(response.isSuccessful){
            Singleton.likedFoodsSingleton?.clear()
            response.body()?.let {
                it.message.forEach {likedItem->
                    Singleton.allFoodsSingleton!!.forEach {food->
                        if(food.yemek_adi == likedItem){
                            Singleton.likedFoodsSingleton?.add(food)
                        }
                    }
                }
            }
        }
    }


}