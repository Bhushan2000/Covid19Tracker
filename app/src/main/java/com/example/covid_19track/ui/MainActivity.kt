package com.example.covid_19track.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.covid_19track.R
import com.example.covid_19track.databinding.ActivityMainBinding
import com.example.covid_19track.ui.country.CountryFragment
import com.example.covid_19track.ui.home.HomeFragment
import com.example.covid_19track.ui.more.MoreFragment
import com.example.covid_19track.ui.vaccine.VaccineFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    var fragment: Fragment? = null

    // ViewBinding
    var mainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        mainBinding = ActivityMainBinding.inflate(
            layoutInflater
        )
        val view: View = mainBinding!!.root
        setContentView(view)

        setSupportActionBar(mainBinding!!.toolbar)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(mainBinding!!.navView, navController)

        //loading the default fragment
        loadFragment(HomeFragment())
        mainBinding!!.navView.setOnNavigationItemSelectedListener(this)
        mainBinding!!.navView.itemIconTintList = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        fragment = null
        when (item.itemId) {
            R.id.navigation_home -> fragment = HomeFragment()
            R.id.navigation_country1 -> fragment = CountryFragment()
            R.id.navigation_vaccine -> fragment = VaccineFragment()
            R.id.moreFragment -> fragment = MoreFragment()
        }
        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // Read the state of item position
        fragment = HomeFragment()
    }
}