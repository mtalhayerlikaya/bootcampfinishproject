package com.example.bootcampproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bootcampproje.R
import com.example.bootcampproje.adapter.LikeRecyclerViewAdapter
import com.example.bootcampproje.databinding.FragmentLikeBinding
import com.example.bootcampproje.util.Singleton
import com.example.bootcampproje.util.Singleton.likedFoodsSingleton
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
    private lateinit var binding : FragmentLikeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("like oncreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_like, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(LikeViewModel::class.java)
        println("like onViewCreated")
        println(Singleton.likedFoodsSingleton)
        likedFoodsSingleton?.let {
            val adapter = LikeRecyclerViewAdapter(requireContext(), likedFoodsSingleton!!)
            binding.rvLikeFragment.adapter = adapter
            binding.rvLikeFragment.layoutManager = GridLayoutManager(requireContext()
                ,3,
            GridLayoutManager.VERTICAL,false)
         }

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