package com.example.bootcampproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.bootcampproje.R
import com.example.bootcampproje.databinding.FragmentDetailBinding
import com.example.bootcampproje.model.Yemek
import com.example.bootcampproje.model.YemekEkle
import com.example.bootcampproje.viewmodel.AnasayfaViewModel
import com.example.bootcampproje.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.view.*


class DetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    private lateinit var binding:FragmentDetailBinding
    private lateinit var yemek:Yemek
    private var quantity:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container,false)

        val bundle:DetailFragmentArgs by navArgs()
        yemek = bundle.yemek
        binding.yemek = yemek
        setDetailImage(yemek)






        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)
        listenButtons()
        val addToBasket= YemekEkle(yemek.yemek_adi,
            yemek.yemek_resim_adi,yemek.yemek_fiyat,
            quantity,"mtalhayerlikaya")

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val addToBasket= YemekEkle(yemek.yemek_adi,
                        yemek.yemek_resim_adi,yemek.yemek_fiyat,
                        quantity,"mtalhayerlikaya")
                    //println("geri geldin")
                   // println(addToBasket)
                    viewModel.addTobasket(addToBasket)
                    quantity=0
                    findNavController().popBackStack()
                }
            })
    }

    private fun setDetailImage(yemek: Yemek){
        Glide
            .with(requireActivity())
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}")
            .centerCrop()
            .into(binding.detailFoodImage);
    }

    private fun listenButtons(){
        binding.increaseImageView.setOnClickListener {
            quantity += 1
            binding.quantityTextView.setText(quantity.toString())
        }

        binding.decreaseImageView.setOnClickListener {
            if(quantity>0){
                quantity -= 1
                binding.quantityTextView.setText(quantity.toString())
            }
        }
    }



}