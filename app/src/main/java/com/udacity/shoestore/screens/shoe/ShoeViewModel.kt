package com.udacity.shoestore.screens.shoe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    val allShoes = mutableListOf(
            Shoe("Rhinestones Sandals", 36.0, "ebay", "Gold High-Heels Party Shoes!", listOf("R.drawable.rhinestones")),
            Shoe("Summer 002", 37.0, "Shoes&Co", "Perfect for summer days!", listOf("R.drawable.rhinestones")),
            Shoe("Summer 003", 38.0, "Shoes&Co", "Perfect for summer days!", listOf("R.drawable.rhinestones")),
            Shoe("Summer 004", 39.0, "Shoes&Co", "Perfect for summer days!", listOf("R.drawable.rhinestones"))
    )

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    init {
        Log.i("ShoeViewModel", "ShoeViewModel created!")
        _shoes.value = allShoes
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeViewModel", "Called just before on ShoeViewModel destroyed!")
    }
}