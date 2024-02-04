package com.example.covid_19track.data.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.covid_19track.data.Network.ApiService
import com.example.covid_19track.util.Resource
import kotlinx.coroutines.*
import java.lang.Exception

class CountryViewModel(private val apiService: ApiService) : ViewModel() {


//
//    A LifecycleScope is defined for each Lifecycle object. LifecycleOwner could be an Activity or a Fragment. Any coroutine launched in this scope is canceled when the Lifecycle is destroyed. This helps us in avoiding memory leaks.
//    Here we have used liveData(Dispatchers.IO). If we observe the import statement:
//    import androidx.lifecycle.liveData


//    Hence, the result of the function will be emitted as Live Data, which can be observed in the view (Activity or Fragment).


    fun fetchData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiService.getData()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
        }
    }

    fun fetchHomeData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiService.getHomeData()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
        }
    }

//    val country = MutableLiveData<MutableList<CovidCountryDataClass>>()
//
//    val homeData = MutableLiveData<HomeData>()
//
//
//    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
//        Log.d(TAG, "Exception handled: ${throwable.localizedMessage}")
//    }



//    fun fetchHomeData() {
//
//        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//            try {
//                val response = apiService.getHomeData()
//                withContext(Dispatchers.Main) {
//
//                    if (response.isSuccessful) {
//                        homeData.value = response.body()
//
//                    } else {
//                        Log.d(TAG, "Error : ${response.message()} ")
//                    }
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//
//            }
//
//        }
//
//
//    }


//    private fun fetchData() {
//
//        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
//
//            try {
//                val response = apiService.getData()
//                withContext(Dispatchers.Main) {
//
//                    if (response.isSuccessful) {
//                        country.value = response.body()
//
//                    } else {
//                        Log.d(TAG, "Error : ${response.message()} ")
//                    }
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//
//            }
//
//        }
//
//
//    }


//    override fun onCleared() {
//        super.onCleared()
//        job?.cancel()
//    }


}