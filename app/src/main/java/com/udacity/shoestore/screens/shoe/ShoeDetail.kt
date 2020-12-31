package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetail : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false)

        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel
        binding.shoe = viewModel._shoe

        viewModel.shouldNavigate.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {
                binding.root.findNavController().navigate(R.id.action_shoeDetail_to_shoeList2)
                viewModel.setNavigation(false)
            }
        })


        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetail_to_shoeList2)
        }


        return binding.root
    }

}