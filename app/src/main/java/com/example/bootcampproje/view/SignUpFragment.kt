package com.example.bootcampproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.bootcampproje.R
import com.example.bootcampproje.databinding.FragmentSignUpBinding
import com.example.bootcampproje.model.SignUpRequest
import com.example.bootcampproje.viewmodel.AnasayfaViewModel
import com.example.bootcampproje.viewmodel.SignUpViewModel
import com.google.android.material.snackbar.Snackbar


class SignUpFragment : Fragment() {

    private lateinit var binding:FragmentSignUpBinding
    private lateinit var viewModel:SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SignUpViewModel::class.java)

        binding.signUpButton.setOnClickListener {
            val name = binding.signUpUsername.text.toString()
            val password = binding.signUpPassword.text.toString()
            println(name)
            println(password)
            val req = SignUpRequest(name,password)
            viewModel.loadSignUpRepo(req)
        }
        registerToObserver()
    }

    private fun registerToObserver(){
        viewModel.signUpResponse.observe(viewLifecycleOwner, Observer {

            when(it?.success){

                0->{
                    Snackbar.make(requireView(),it.message, Snackbar.LENGTH_SHORT).show()
                    viewModel.clearResponse()
                }

                1->{
                    Snackbar.make(requireView(),it.message,Snackbar.LENGTH_SHORT).show()
                    Navigation.findNavController(requireView()).navigate(R.id.action_signUpFragment_to_loginFragment)
                    viewModel.clearResponse()
                }


            }


        })


    }


}