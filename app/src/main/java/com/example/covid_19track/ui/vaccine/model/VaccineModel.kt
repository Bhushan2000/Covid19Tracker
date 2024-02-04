package com.example.covid_19track.ui.vaccine.model

import com.google.gson.annotations.SerializedName

data class VaccineModel(


    @SerializedName("centers") val centers: List<Centers>

)
