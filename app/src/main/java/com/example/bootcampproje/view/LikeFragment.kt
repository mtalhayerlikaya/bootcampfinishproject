package com.example.bootcampproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bootcampproje.R
import com.example.bootcampproje.util.Singleton
import com.example.bootcampproje.viewmodel.BasketViewModel
import com.example.bootcampproje.viewmodel.LikeVMF
import com.example.bootcampproje.viewmodel.LikeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class LikeFragment : Fragment() {
    val scope = CoroutineScope(Dispatchers.IO+Job())
    private lateinit var viewModel: LikeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_like, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(LikeViewModel::class.java)


        /*Singleton.allFoodsSingleton?.let {
            it.forEach {yemek ->
                println(yemek)
            }
        }*/

   /*     viewModel.likedList.observe(viewLifecycleOwner, Observer {

            when(it.success){

                1->{
                    it.message.forEach {
                        println(it)
                    }
                }

                0->{

                }

            }

        })
*/

    }


}