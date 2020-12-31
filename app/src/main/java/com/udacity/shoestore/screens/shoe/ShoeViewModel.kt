package com.udacity.shoestore.screens.shoe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import kotlin.math.log

class ShoeViewModel : ViewModel() {

    lateinit var _shoe: Shoe

    val allShoes = mutableListOf(
            Shoe("Rhinestones Sandals", 36.0, "ebay", "Gold High-Heels Party Shoes!", listOf("R.drawable.rhinestones")),
            Shoe("Summer 002", 37.0, "Shoes&Co", "Perfect for summer days!", listOf("R.drawable.rhinestones")),
            Shoe("Summer 003", 38.0, "Shoes&Co", "Perfect for summer days!", listOf("R.drawable.rhinestones")),
            Shoe("Summer 004", 39.0, "Shoes&Co", "Perfect for summer days!", listOf("R.drawable.rhinestones"))
    )

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private var _shouldNavigate = MutableLiveData<Boolean>()
    val shouldNavigate: LiveData<Boolean>
        get() = _shouldNavigate

    init {
        Log.i("ShoeViewModel", "ShoeViewModel created!")
        _shoes.value = allShoes
        _shoe = Shoe("", 0.0, "", "", listOf(""))
        _shouldNavigate.value = false
    }

    fun addShoe(shoe: Shoe) {
        _shoe = Shoe(shoe.name, shoe.size, shoe.company, shoe.description, listOf("R.drawable.rhinestones"))
        allShoes.add(_shoe)
        Log.i("ShoeViewModel", "New shoe added")
        _shoe = Shoe("", 0.0, "", "", listOf(""))
        _shouldNavigate.value = true
    }

    fun setNavigation(shouldNavigate: Boolean) {
        _shouldNavigate.value = shouldNavigate
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("ShoeViewModel", "Called just before on ShoeViewModel destroyed!")
    }
}