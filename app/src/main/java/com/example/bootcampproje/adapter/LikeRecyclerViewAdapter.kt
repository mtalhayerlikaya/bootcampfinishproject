package com.example.bootcampproje.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampproje.databinding.RecyclerviewLikedItemBinding
import com.example.bootcampproje.model.Yemek

class LikeRecyclerViewAdapter(var mContext: Context, var list:List<Yemek>) : RecyclerView.Adapter<LikeRecyclerViewAdapter.LikeViewHolder>() {
    inner class LikeViewHolder(recyclerviewLikedItemBinding: RecyclerviewLikedItemBinding) : RecyclerView.ViewHolder(recyclerviewLikedItemBinding.root){
        var recyclerviewLikedItemBinding : RecyclerviewLikedItemBinding
        init {
            this.recyclerviewLikedItemBinding = recyclerviewLikedItemBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val inflater = RecyclerviewLikedItemBinding.inflate(layout,parent,false)
        return LikeViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: LikeViewHolder, position: Int) {
          holder.recyclerviewLikedItemBinding.likeRvItemFoodName.text = list.get(position).yemek_adi
          holder.recyclerviewLikedItemBinding.likeRvItemFoodPrice.text = "₺"+list.get(position).yemek_fiyat.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}