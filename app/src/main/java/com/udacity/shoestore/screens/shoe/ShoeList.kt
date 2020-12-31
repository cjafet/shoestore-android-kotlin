package com.udacity.shoestore.screens.shoe

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeItemBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeList : Fragment() {

    //private lateinit var viewModel: ShoeViewModel
    private val viewModel: ShoeViewModel by activityViewModels()
    //private lateinit var binding: FragmentShoeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
                inflater, R.layout.fragment_shoe_list, container, false)

        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeListDirections.actionShoeListToShoeDetail())
        }

        Log.i("ShoeList", "Calling ViewModelProvider!")

        //viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            //binding.nameView.text = shoes[0].name
            for (item in shoes){
                val shoeItemBinding = FragmentShoeItemBinding.inflate(layoutInflater,null, false)
                shoeItemBinding.textName.text = item.name
                shoeItemBinding.textCompany.text = item.company
                shoeItemBinding.textDescription.text = item.description
                shoeItemBinding.textSize.text = item.size.toString()
                shoeItemBinding.imageShoe.setBackgroundResource(R.drawable.rhinestones)
                binding.linearlayout.addView(shoeItemBinding.root)
                //binding.linearLayout.addView(shoeItemBinding.root)
            }
        })

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_shoe_list, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}