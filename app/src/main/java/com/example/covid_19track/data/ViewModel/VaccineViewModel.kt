package com.example.covid_19track.data.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.covid_19track.data.Network.ApiService
import com.example.covid_19track.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class VaccineViewModel(private val apiService: ApiService) : ViewModel() {

    fun fetchVaccine( pincode:String,date:String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiService.getVaccineData( pincode = pincode,date = date)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
        }
    }

}