package com.example.covid_19track.ui.country


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19track.R
import com.example.covid_19track.data.ViewModel.CountryViewModel
import com.example.covid_19track.data.Model.CovidCountry
import com.example.covid_19track.data.Network.ApiService
import com.example.covid_19track.data.Network.RetrofitInstance
import com.example.covid_19track.data.ViewModel.ViewModelFactory
import com.example.covid_19track.databinding.FragmentCountryBinding
import com.example.covid_19track.util.Status
import java.util.*


class CountryFragment : Fragment() {

    private var covidCountries: MutableList<CovidCountry> = mutableListOf()

    lateinit var binding: FragmentCountryBinding

    lateinit var countryViewModel: CountryViewModel

    private var covidCountryAdapter: CovidCountryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCountryBinding.inflate(inflater, container, false)

        val root: View = binding.root

        requireActivity().title = "Countries"

        //set has option menu as true because we have menu
        setHasOptionsMenu(true)
        setUpViewModel()
        setUpObserver()
        setupUI()

        return root


    }

    private fun setUpViewModel() {
        countryViewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitInstance.apiClient().create(ApiService::class.java))
        )[CountryViewModel::class.java]

    }

    private fun setupUI() {
        binding.rvCovidCountry.layoutManager = LinearLayoutManager(activity)

        binding.swipeToRefresh.setOnRefreshListener {
            covidCountries.clear()
            countryViewModel.fetchData()

            binding.swipeToRefresh.isRefreshing = false
        }
        binding.rvCovidCountry.itemAnimator = DefaultItemAnimator()

        covidCountryAdapter = CovidCountryAdapter(
            covidCountries,
            requireContext()
        )

        binding.rvCovidCountry.adapter = covidCountryAdapter

    }

    private fun setUpObserver() {
        countryViewModel.fetchData().observe(viewLifecycleOwner, Observer {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        showProgress(false)
                        resource.data?.let { response -> retrieveList(response.body()!!) }
                        Log.d(TAG, "setUpObserver: ")
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


    private fun retrieveList(list: MutableList<CovidCountry>) {
        if (list.size > 0) {
            covidCountries.addAll(list)
            covidCountryAdapter?.notifyDataSetChanged()
        }
    }

    private fun showProgress(status: Boolean) {
        if (status) {
            binding.progressCircularCountry.visibility = View.VISIBLE
        } else {
            binding.progressCircularCountry.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search, menu)

        super.onCreateOptionsMenu(menu, inflater)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = SearchView(
            requireActivity()
        )
        searchView.queryHint = "Search..."
        searchView.maxWidth = Int.MAX_VALUE
        searchItem.actionView = searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                search(newText)
                return false

            }
        })


    }

    private fun search(text: String?) {
        var covidCountriesFilterList: MutableList<CovidCountry> = mutableListOf()

        // running a for loop to compare elements.
        // running a for loop to compare elements.
        for (item in covidCountries) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.country.lowercase(Locale.getDefault()).contains(text!!.lowercase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                covidCountriesFilterList.add(item)
            }
        }
        if (covidCountriesFilterList.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Log.d(TAG, "search: " + "No Data Found..")
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            covidCountryAdapter?.filterList(covidCountriesFilterList)
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort_alpha -> {
                covidCountries.sortWith(compareBy { it.country })
                covidCountryAdapter?.notifyDataSetChanged()
                return true
            }
            R.id.action_sort_cases -> {

                covidCountries.sortByDescending {
                    it.cases
                }

                covidCountryAdapter?.notifyDataSetChanged()

                return true
            }
            R.id.action_search -> {


                return true
            }


        }

        return super.onOptionsItemSelected(item)
    }


}