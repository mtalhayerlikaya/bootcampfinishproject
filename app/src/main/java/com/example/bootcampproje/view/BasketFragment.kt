package com.example.bootcampproje.view

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampproje.R
import com.example.bootcampproje.adapter.BasketRecyclerViewAdapter
import com.example.bootcampproje.databinding.FragmentBasketBinding
import com.example.bootcampproje.model.SepetYemek
import com.example.bootcampproje.model.Yemek
import com.example.bootcampproje.repo.BasketFragmentRepo
import com.example.bootcampproje.viewmodel.BasketViewModel
import com.example.bootcampproje.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_basket.view.*
import javax.inject.Inject


class BasketFragment : Fragment() {
    private lateinit var binding: FragmentBasketBinding
    private lateinit var viewModel: BasketViewModel
    private lateinit var adapter : BasketRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  val tempViewModel: BasketViewModel by viewModels()
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
        //adapter = BasketRecyclerViewAdapter(requireContext(), mutableListOf(),viewModel)
        val itemSwipe = object:ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               // viewModel.deleteFood(viewHolder.itemView.)

                val position = viewHolder.adapterPosition
                adapter.remove(position)

            }

        }
        val swap = ItemTouchHelper(itemSwipe)
        swap.attachToRecyclerView(binding.recyclerView)

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


    fun calculateBasket(){

    }

   private fun registerToObserver() {

           viewModel.basList.observe(viewLifecycleOwner, Observer {

                        val listOnBasket = viewModel.checkIfExistInBasket(it.sepet_yemekler)
                        adapter = BasketRecyclerViewAdapter(requireContext(),
                            listOnBasket,viewModel)
                        binding.recyclerView.adapter = adapter
                        binding.recyclerView.layoutManager =
                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


           })

   }


    override fun onDestroy() {
        super.onDestroy()

    }

}