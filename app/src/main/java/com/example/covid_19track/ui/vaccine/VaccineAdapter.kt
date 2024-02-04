package com.example.covid_19track.ui.vaccine

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19track.R
import com.example.covid_19track.ui.vaccine.VaccineAdapter.VaccineVH
import com.example.covid_19track.ui.vaccine.model.Centers
import com.example.covid_19track.ui.vaccine.model.Sessions
import com.example.covid_19track.ui.vaccine.model.VaccineModel
import kotlin.math.log

class VaccineAdapter(
    private val centers: List<Centers>,
    private val context: Context?
) : RecyclerView.Adapter<VaccineVH>() {
    var lastPosition = -1
    val list: MutableList<Sessions> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.center_rv_item, parent, false)
        return VaccineVH(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VaccineVH, position: Int) {

        var currentItem = centers[position]


        holder.centerNameTV.text = currentItem.name
        holder.centerAddressTV.text = currentItem.address
        holder.centerTimings.text =
            "From : " + currentItem.from + " To : " + currentItem.to




        for (i in centers[position].sessions) {
            list.add(position,i)
        }


        holder.vaccineNameTV.text = list.get(position).vaccine

        holder.centerAgeLimitTV.text =
            "Age Limit : " + list[position].min_age_limit
        holder.centerFeeTypeTV.text = currentItem.fee_type
        holder.avalabilityTV.text =
            "Availability : " + list[position].available_capacity

        try {

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

        try {
            if (lastPosition < position) {
                val animation = AnimationUtils.loadAnimation(
                    holder.itemView.context,
                    R.anim.item_animation_fall_down
                )
                holder.itemView.animation = animation
                lastPosition = position
            }
        } catch (e: Exception) {
            e.printStackTrace()

        }
    }

    override fun getItemCount(): Int {
        Log.d(
            javaClass.simpleName,
            "getItemCount: ...................................${centers.size}"
        )
        return centers.size
    }

    inner class VaccineVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var centerNameTV: TextView
        var centerAddressTV: TextView
        var centerTimings: TextView
        var vaccineNameTV: TextView
        var centerAgeLimitTV: TextView
        var centerFeeTypeTV: TextView
        var avalabilityTV: TextView

        init {
            // on below line we are initializing all our text views along with  its ids.
            centerNameTV = itemView.findViewById(R.id.idTVCenterName)
            centerAddressTV = itemView.findViewById(R.id.idTVCenterAddress)
            centerTimings = itemView.findViewById(R.id.idTVCenterTimings)
            vaccineNameTV = itemView.findViewById(R.id.idTVVaccineName)
            centerAgeLimitTV = itemView.findViewById(R.id.idTVAgeLimit)
            centerFeeTypeTV = itemView.findViewById(R.id.idTVFeeType)
            avalabilityTV = itemView.findViewById(R.id.idTVAvaliablity)
        }
    }
}