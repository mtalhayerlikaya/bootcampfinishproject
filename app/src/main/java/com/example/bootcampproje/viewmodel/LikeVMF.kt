package com.example.bootcampproje.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bootcampproje.view.LikeFragment
import dagger.hilt.android.lifecycle.HiltViewModel


class LikeVMF(var application: Application) :ViewModelProvider.NewInstanceFactory() {


}