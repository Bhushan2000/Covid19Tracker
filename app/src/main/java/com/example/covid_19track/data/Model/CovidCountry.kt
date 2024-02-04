package com.example.covid_19track.data.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CovidCountry(
    @SerializedName("updated") var updated: Long,
    @SerializedName("country") var country: String,
    @SerializedName("countryInfo") var countryInfo: CountryInfo,
    @SerializedName("cases") var cases: Int,
    @SerializedName("todayCases") var todayCases: Int,
    @SerializedName("deaths") var deaths: Int,
    @SerializedName("todayDeaths") var todayDeaths: Int,
    @SerializedName("recovered") var recovered: Int,
    @SerializedName("todayRecovered") var todayRecovered: Int,
    @SerializedName("active") var active: Int,
    @SerializedName("critical") var critical: Int,
    @SerializedName("casesPerOneMillion") var casesPerOneMillion: Int,
    @SerializedName("deathsPerOneMillion") var deathsPerOneMillion: Double,
    @SerializedName("tests") var tests: Int,
    @SerializedName("testsPerOneMillion") var testsPerOneMillion: Int,
    @SerializedName("population") var population: Int,
    @SerializedName("continent") var continent: String,
    @SerializedName("oneCasePerPeople") var oneCasePerPeople: Int,
    @SerializedName("oneDeathPerPeople") var oneDeathPerPeople: Int,
    @SerializedName("oneTestPerPeople") var oneTestPerPeople: Int,
    @SerializedName("undefined") var undefined: Int,
    @SerializedName("activePerOneMillion") var activePerOneMillion: Double,
    @SerializedName("recoveredPerOneMillion") var recoveredPerOneMillion: Double,
    @SerializedName("criticalPerOneMillion") var criticalPerOneMillion: Double


)






