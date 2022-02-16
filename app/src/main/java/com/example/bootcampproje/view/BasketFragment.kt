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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bootcampproje.R
import com.example.bootcampproje.adapter.BasketRecyclerViewAdapter
import com.example.bootcampproje.databinding.FragmentBasketBinding
import com.example.bootcampproje.model.SepetYemek
import com.example.bootcampproje.model.Yemek
import com.example.bootcampproje.repo.BasketFragmentRepo
import com.example.bootcampproje.viewmodel.BasketViewModel
import com.example.bootcampproje.viewmodel.DetailViewModel
import javax.inject.Inject


class BasketFragment : Fragment() {
    private lateinit var binding: FragmentBasketBinding
    private lateinit var viewModel: BasketViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*val tempViewModel: BasketViewModel by viewModels(){
            BasketFragmentRepo()
        }
        viewModel = tempViewModel*/
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadBasketList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_basket, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(BasketViewModel::class.java)


        registerToObserver()

    }

    private fun listenBasketItems(){

    /*    binding..setOnClickListener {
            quantity += 1
            binding.quantityTextView.setText(quantity.toString())
        }

        binding.decreaseImageView.setOnClickListener {
            if(quantity>0){
                quantity -= 1
                binding.quantityTextView.setText(quantity.toString())
            }
        }*/
    }

    fun checkIfExistInBasket(list:List<SepetYemek>):List<SepetYemek>{
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

        return hashMap.values.toList()
    }

    fun registerToObserver(){
        viewModel.basList.observe(viewLifecycleOwner, Observer{
            if(!it.sepet_yemekler.isEmpty()){
                val listOnBasket = checkIfExistInBasket(it.sepet_yemekler)
                val adapter =BasketRecyclerViewAdapter(requireContext(),listOnBasket)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            }else{
                println("basket is empty")
            }

        })
    }


}