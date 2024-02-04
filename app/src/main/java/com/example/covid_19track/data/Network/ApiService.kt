package com.example.covid_19track.data.Network


import com.example.covid_19track.data.Model.CovidCountry
import com.example.covid_19track.data.Model.HomeData
import com.example.covid_19track.ui.vaccine.model.VaccineModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/countries")
    suspend fun getData(): Response<MutableList<CovidCountry>>

    // @GET("/v2/all")

    @GET("/v3/covid-19/all")
    suspend fun getHomeData(): Response<HomeData>

    @GET("/api/v2/appointment/sessions/public/calendarByPin")
    suspend fun getVaccineData(
        @Query("pincode") pincode: String,
        @Query("date") date: String
    ): Response<VaccineModel>

}

