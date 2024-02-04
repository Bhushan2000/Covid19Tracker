package com.example.covid_19track.data.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covid_19track.data.Network.ApiService
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {
// We will be providing our View Model from a Factory class. So let’s construct our ViewModelFactory class:
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            return CountryViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}