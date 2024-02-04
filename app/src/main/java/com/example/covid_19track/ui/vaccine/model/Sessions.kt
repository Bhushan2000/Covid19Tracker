package com.example.covid_19track.ui.vaccine.model

import com.google.gson.annotations.SerializedName

data class Sessions (

    @SerializedName("session_id") val session_id : String,
    @SerializedName("date") val date : String,
    @SerializedName("available_capacity") val available_capacity : Int,
    @SerializedName("min_age_limit") val min_age_limit : Int,
    @SerializedName("allow_all_age") val allow_all_age : Boolean,
    @SerializedName("vaccine") val vaccine : String,
    @SerializedName("slots") val slots : List<String>,
    @SerializedName("available_capacity_dose1") val available_capacity_dose1 : Int,
    @SerializedName("available_capacity_dose2") val available_capacity_dose2 : Int
)