package com.example.covid_19track.ui.vaccine.model

import com.google.gson.annotations.SerializedName

data class Centers (

    @SerializedName("center_id") val center_id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("address") val address : String,
    @SerializedName("state_name") val state_name : String,
    @SerializedName("district_name") val district_name : String,
    @SerializedName("block_name") val block_name : String,
    @SerializedName("pincode") val pincode : Int,
    @SerializedName("lat") val lat : Int,
    @SerializedName("long") val long : Int,
    @SerializedName("from") val from : String,
    @SerializedName("to") val to : String,
    @SerializedName("fee_type") val fee_type : String,
    @SerializedName("sessions") val sessions : List<Sessions>
)