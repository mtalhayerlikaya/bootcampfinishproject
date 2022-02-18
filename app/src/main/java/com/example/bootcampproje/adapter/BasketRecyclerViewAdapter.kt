package com.example.bootcampproje.adapter

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootcampproje.databinding.RecyclerviewBasketItemBinding
import com.example.bootcampproje.model.SepetYemek
import com.example.bootcampproje.model.Yemek
import com.example.bootcampproje.viewmodel.BasketViewModel

class BasketRecyclerViewAdapter(var mContext: Context,var list:MutableList<SepetYemek>,var viewModel:BasketViewModel): RecyclerView.Adapter<BasketRecyclerViewAdapter.BasketViewHolder>() {
    class BasketViewHolder(recyclerviewBasketItemBinding: RecyclerviewBasketItemBinding):RecyclerView.ViewHolder(recyclerviewBasketItemBinding.root){
        var recyclerviewBasketItemBinding:RecyclerviewBasketItemBinding

        init {
            this.recyclerviewBasketItemBinding = recyclerviewBasketItemBinding
        }

    }

    fun remove( position: Int){
        val yemek = list[position].yemek_adi
        viewModel.deleteFood(list[position].kullanici_adi,list[position].sepet_yemek_id.toInt())
        list = viewModel.checkIfExistInBasket(list)
        //val el = list[position]
        list.remove(list.first { it.yemek_adi == yemek })
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding = RecyclerviewBasketItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return BasketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val a = holder.recyclerviewBasketItemBinding

        a.basketFoodName.text =list[position].yemek_adi
        a.basketFoodPrice.text ="₺"+list[position].yemek_fiyat.toString()
        a.basketFoodCount.text = list[position].yemek_siparis_adet.toString()
        Glide
            .with(mContext)
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${list[position].yemek_resim_adi}")
            .centerCrop()
            .into(a.foodImage)

         /*  a.increaseBasketItem.setOnClickListener {
               val quantity = list[position].yemek_siparis_adet+1
               a.basketFoodCount.text =quantity.toString()
               //viewModel.addTobasket()
           }
           a.decreaseBasketItem.setOnClickListener {
               val quantity = list[position].yemek_siparis_adet-1
               a.basketFoodCount.text =quantity.toString()
           }*/


    }

    override fun getItemCount(): Int {
        return list.size
    }
}