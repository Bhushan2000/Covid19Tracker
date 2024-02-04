package com.example.covid_19track.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.covid_19track.data.Network.ApiService
import com.example.covid_19track.data.Network.RetrofitInstance
import com.example.covid_19track.data.ViewModel.CountryViewModel
import com.example.covid_19track.data.ViewModel.ViewModelFactory
import com.example.covid_19track.databinding.FragmentHomeBinding
import com.example.covid_19track.util.Status
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    var binding: FragmentHomeBinding? = null
    lateinit var countryViewModel: CountryViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view: View = binding!!.root


        // actionBar Title
        requireActivity().title = "Overview"

        setupViewModel()

        setUpObserver()

        return view
    }

    private fun setupViewModel() {

        countryViewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitInstance.apiClient().create(ApiService::class.java))
        ).get(CountryViewModel::class.java)


    }

    fun setUpObserver() {
        countryViewModel.fetchHomeData().observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        showProgress(false)
                        resource.data?.body()
                        binding!!.tvTotalConfirmed.text = resource.data?.body()?.cases.toString()
                        binding!!.tvTotalDeaths.text = resource.data?.body()?.deaths.toString()
                        binding!!.tvTotalRecovered.text = resource.data?.body()?.recovered.toString()
                        binding!!.tvLastUpdated.text = resource.data?.body()?.let { it1 ->
                            getData(
                                it1.updated)
                        }

                    }
                    Status.ERROR -> {
                        showProgress(false)
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        showProgress(true)
                    }
                }
            }


        })



    }


    private fun getData(milliSecond: Long): String {
        val simpleDateFormat = SimpleDateFormat("EEEE,dd MMM yyyy hh:mm:ss aaa")
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSecond
        return simpleDateFormat.format(calendar.time)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val TAG = "HomeFragment"
    }



    private fun showProgress(status: Boolean) {
        if (status) {
            binding!!.progressCircularHome.visibility = View.VISIBLE
        } else {
            binding!!.progressCircularHome.visibility = View.GONE
        }
    }

}