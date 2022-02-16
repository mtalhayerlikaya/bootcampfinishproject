package com.example.bootcampproje.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampproje.databinding.RecyclerviewBasketItemBinding
import com.example.bootcampproje.model.SepetYemek
import com.example.bootcampproje.model.Yemek

class BasketRecyclerViewAdapter(var mContext: Context,var list:List<SepetYemek>): RecyclerView.Adapter<BasketRecyclerViewAdapter.BasketViewHolder>() {
    class BasketViewHolder(recyclerviewBasketItemBinding: RecyclerviewBasketItemBinding):RecyclerView.ViewHolder(recyclerviewBasketItemBinding.root){
        var recyclerviewBasketItemBinding:RecyclerviewBasketItemBinding

        init {
            this.recyclerviewBasketItemBinding = recyclerviewBasketItemBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val binding = RecyclerviewBasketItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return BasketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val a = holder.recyclerviewBasketItemBinding
        holder.recyclerviewBasketItemBinding.basketFoodName.text =list[position].yemek_adi
        holder.recyclerviewBasketItemBinding.basketFoodPrice.text =list[position].yemek_fiyat.toString()
        holder.recyclerviewBasketItemBinding.basketFoodCount.text = list[position].yemek_siparis_adet.toString()

        /*holder.recyclerviewBasketItemBinding.increaseBasketItem.setOnClickListener {
            var quantity = a.basketFoodCount.text.toString().toInt() + 1
            a.basketFoodCount.setText(quantity.toString())
        }

        holder.recyclerviewBasketItemBinding.decreaseImageView.setOnClickListener {
            if(quantity>0){
                quantity -= 1
                binding.quantityTextView.setText(quantity.toString())
            }
        }*/

    }

    override fun getItemCount(): Int {
        return list.size
    }
}