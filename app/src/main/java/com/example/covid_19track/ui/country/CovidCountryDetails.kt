package com.example.covid_19track.ui.country

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.covid_19track.data.Model.CovidCountry
import com.example.covid_19track.databinding.ActivityCovidCountryDetailsBinding
import java.util.*
import android.graphics.drawable.Drawable
import com.bumptech.glide.request.target.CustomTarget
import androidx.annotation.NonNull
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.request.transition.Transition
import android.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener

import com.google.android.material.appbar.CollapsingToolbarLayout


class CovidCountryDetails : AppCompatActivity() {

    var binding: ActivityCovidCountryDetailsBinding? = null
    var list: MutableList<CovidCountry> =
        ArrayList<CovidCountry>()



    @SuppressLint("SetTextI18n", "WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCovidCountryDetailsBinding.inflate(
            layoutInflater
        )
        val view: View = binding!!.root
        setContentView(view)

        setSupportActionBar(binding!!.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);


        val countryName = intent.getStringExtra("country")
        val todayCase = intent.getStringExtra("todayCase")
        val todayDeath = intent.getStringExtra("todayDeath")
        val totalCases = intent.getStringExtra("cases")
        val totalDeaths = intent.getStringExtra("deaths")
        val totalRecovered = intent.getStringExtra("recovered")
        val active = intent.getStringExtra("active")
        val critical = intent.getStringExtra("critical")
        val continent = intent.getStringExtra("continent")
        val population = intent.getStringExtra("population")
        val todayRecovered = intent.getStringExtra("todayRecovered")
        val test = intent.getStringExtra("tests")
        val flag = intent.getStringExtra("flag")


        binding!!.tvTotalCountryName.text = countryName
        supportActionBar!!.title = countryName



        binding!!.tvDetailTotalCases.text = totalCases
        binding!!.tvDetailTodayCases.text = todayCase
        binding!!.tvDetailTotalDeaths.text = totalDeaths
        binding!!.tvDetailTodayDeaths.text = todayDeath
        binding!!.tvDetailTotalRecovered.text = totalRecovered
        binding!!.tvDetailTotalActive.text = active
        binding!!.tvDetailTotalCritical.text = critical
        binding!!.tvContinent.text = continent
        binding!!.tvPopulation.text = population
        binding!!.tvTodayRecovered.text = todayRecovered
        binding!!.tvTests.text = test



        Glide
            .with(this)
            .load(flag)
            .apply(RequestOptions())
            .override(240, 160)
            .into(binding!!.imageView)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

 }


