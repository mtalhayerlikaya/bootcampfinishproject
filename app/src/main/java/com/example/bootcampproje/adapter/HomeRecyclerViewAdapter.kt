package com.example.bootcampproje.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.bootcampproje.R
import com.example.bootcampproje.databinding.HomeRecyclerViewItemBinding
import com.example.bootcampproje.model.Yemek
import com.example.bootcampproje.view.HomeFragmentDirections
import javax.inject.Inject

class HomeRecyclerViewAdapter(var mContext: Context, var list:List<Yemek>): RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {

    class HomeViewHolder(recyclerViewItemBinding: HomeRecyclerViewItemBinding): RecyclerView.ViewHolder(recyclerViewItemBinding.root) {
        var recyclerViewItemBinding:HomeRecyclerViewItemBinding

        init {
            this.recyclerViewItemBinding = recyclerViewItemBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = HomeRecyclerViewItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
      //  holder.recyclerViewItemBinding.foodName.text = list.get(position).yemek_adi
      //  holder.recyclerViewItemBinding.foodPrice.text = "$"+list.get(position).yemek_fiyat.toString()
        var a = holder.recyclerViewItemBinding
        val yemek = list.get(position)
        a.comingValue =yemek
            Glide
                .with(mContext)
                .load("http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}")
                .centerCrop()
                .into(a.foodImage)

            a.cardViewHome.setOnClickListener {
            val info = HomeFragmentDirections.actionHomeFragmentToDetayFragment(list[position])
            Navigation.findNavController(it).navigate(info)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}