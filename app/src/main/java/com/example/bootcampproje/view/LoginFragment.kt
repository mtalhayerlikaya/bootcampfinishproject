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
import com.example.bootcampproje.databinding.FragmentLoginBinding
import com.example.bootcampproje.model.LoginRequest
import com.example.bootcampproje.viewmodel.AnasayfaViewModel
import com.example.bootcampproje.viewmodel.LoginFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var viewModel:LoginFragmentViewModel
    private lateinit var binding:FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(LoginFragmentViewModel::class.java)

        loginButton.setOnClickListener {
            val name = binding.usernameText.text.toString()
            val pass = binding.passwordText.text.toString()
            val req = LoginRequest(name,pass)
            println(req)
            viewModel.loadRepoLiveData(req)
        }
        registerToObserver()
    }

    private fun registerToObserver(){
        viewModel.loginLiveData.observe(viewLifecycleOwner, Observer {
            when(it.success){

                0->{
                 Snackbar.make(requireView(),it.message,Snackbar.LENGTH_SHORT).show()
                }

                1->{
                    Snackbar.make(requireView(),it.message,Snackbar.LENGTH_SHORT).show()
                    Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_homeFragment)
                }

            }
        })
    }


}