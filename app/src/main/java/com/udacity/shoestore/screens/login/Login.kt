package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

private lateinit var binding: FragmentLoginBinding
private var isLogged = false


class Login : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment with Data Binding
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false)

        binding.loginButton.setOnClickListener { view: View ->
            if (isLogged) {
                view.findNavController().navigate(LoginDirections.actionFragmentLoginToShoeList())
            } else {
                view.findNavController().navigate(LoginDirections.actionLoginToWelcome())
                isLogged = true
            }
        }

        binding.registerButton.setOnClickListener { view: View ->
            if (isLogged) {
                view.findNavController().navigate(LoginDirections.actionFragmentLoginToShoeList())
            } else {
                view.findNavController().navigate(LoginDirections.actionLoginToWelcome())
                isLogged = true
            }
        }

        return binding.root

    }



}