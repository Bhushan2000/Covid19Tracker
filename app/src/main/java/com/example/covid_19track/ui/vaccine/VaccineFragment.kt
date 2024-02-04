package com.example.covid_19track.ui.vaccine

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19track.data.Network.ApiService
import com.example.covid_19track.data.Network.RetrofitInstance
import com.example.covid_19track.data.ViewModel.CountryViewModel
import com.example.covid_19track.data.ViewModel.VaccineModelFactory
import com.example.covid_19track.data.ViewModel.VaccineViewModel
import com.example.covid_19track.databinding.FragmentVaccineBinding
import com.example.covid_19track.ui.vaccine.model.VaccineModel
import com.example.covid_19track.util.Status
import java.text.SimpleDateFormat
import java.util.*


class VaccineFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    // creating a variable for our recycler view.
    var centersRV: RecyclerView? = null

    // creating a variable for adapter class.
    var vaccineAdapter: VaccineAdapter? = null

    // creating a variable for progress bar.
    var loadingPB: ProgressBar? = null

    lateinit var vaccineVM: VaccineViewModel

    lateinit var countryViewModel: CountryViewModel

    var TAG: String = javaClass.simpleName

    var binding: FragmentVaccineBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentVaccineBinding.inflate(inflater, container, false)
        val view: View = binding!!.root
        requireActivity().title = "Vaccination"




        setUpViewModel()






        binding!!.idBtnSearch.setOnClickListener {
            var pincode = binding!!.idEdtPinCode.text.toString()


            // on below line we are validating
            // our pin code as 6 digit or not.
            if (pincode.length != 6) {
                // this method is called when users enter invalid pin code.
                Toast.makeText(context, "Please enter valid pin code", Toast.LENGTH_SHORT).show()
            } else {
                getAppointments(binding!!.idEdtPinCode.text.toString())


            }
        }



        return view
    }

    private fun setUpViewModel() {
        vaccineVM = ViewModelProvider(
            this,
            VaccineModelFactory(RetrofitInstance.apiClientVaccine().create(ApiService::class.java))
        ).get(VaccineViewModel::class.java)
    }


    private fun getAppointments(pincode: String) {


        val pattern = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date = simpleDateFormat.format(Date())

        vaccineVM.fetchVaccine(pincode, date)

            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {

                it.let { resource ->

                    when (resource.status) {

                        Status.SUCCESS -> {

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

    private fun showProgress(status: Boolean) {
        if (status) {
            binding!!.idPBLoading.visibility = View.VISIBLE
        } else {
            binding!!.idPBLoading.visibility = View.GONE
        }
    }
}