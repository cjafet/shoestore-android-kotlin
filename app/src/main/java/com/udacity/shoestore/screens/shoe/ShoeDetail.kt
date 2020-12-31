package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

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
        //return inflater.inflate(R.layout.fragment_shoe_detail, container, false)


        binding.saveShoe.setOnClickListener { view: View ->
            val size: String = binding.shoeSize.text.toString()
            viewModel.allShoes.add(Shoe(binding.shoeName.text.toString(), size.toDouble(), binding.companyName.text.toString(), binding.shoeDescription.text.toString(), listOf("R.drawable.rhinestones")))
            view.findNavController().navigate(R.id.action_shoeDetail_to_shoeList2)
        }

        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetail_to_shoeList2)
        }


        return binding.root
    }

}