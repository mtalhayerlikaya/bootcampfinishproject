package com.example.bootcampproje.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bootcampproje.repo.BasketFragmentRepo

class BasketVMF(val repo:BasketFragmentRepo):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BasketViewModel(repo) as T
    }

}