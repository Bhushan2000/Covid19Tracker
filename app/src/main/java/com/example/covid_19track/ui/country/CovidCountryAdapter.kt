package com.example.covid_19track.ui.country

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.covid_19track.R
import com.example.covid_19track.data.Model.CovidCountry


class CovidCountryAdapter(
    private var countryList: MutableList<CovidCountry>,
    private var context: Context
) :
    RecyclerView.Adapter<CovidCountryAdapter.ViewHolder>()

{

    var lastPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_covid_country, parent, false)
        return ViewHolder(view )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val covidCountry = countryList[position]
        holder.tvtotalCases.text = Integer.toString(covidCountry.cases)
        holder.tvCountryName.text = covidCountry.country

        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.progress_animation)
            .error(R.drawable.country_icon)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontAnimate()
            .dontTransform()


        Glide.with(context).load(covidCountry.countryInfo.flag)
            .apply(options).into(holder.imgCountryFlag)




        if (lastPosition < position) {
            val animation = AnimationUtils.loadAnimation(
                holder.itemView.context,
                R.anim.item_animation_fall_down
            )
            holder.itemView.animation = animation
            lastPosition = position
        }


        holder.itemView.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(context, CovidCountryDetails::class.java)



            intent.putExtra("country", covidCountry.country)
            intent.putExtra("todayCase", covidCountry.todayCases.toString())
            intent.putExtra("todayDeath", covidCountry.todayDeaths.toString())
            intent.putExtra("flag", covidCountry.countryInfo.flag)
            intent.putExtra("cases", covidCountry.cases.toString())
            intent.putExtra("deaths", covidCountry.deaths.toString())
            intent.putExtra("tests", covidCountry.tests.toString())
            intent.putExtra("recovered", covidCountry.recovered.toString())

            intent.putExtra("active", covidCountry.active.toString())
            intent.putExtra("critical", covidCountry.critical.toString())
            intent.putExtra("continent", covidCountry.continent)
            intent.putExtra("population", covidCountry.population.toString())
            intent.putExtra("todayRecovered", covidCountry.todayRecovered.toString())


            intent.putExtra("flag", covidCountry.countryInfo.flag)


            context.startActivity(intent)
        })


    }


    override fun getItemCount(): Int {
        return countryList.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvtotalCases: TextView
        var tvCountryName: TextView
        var imgCountryFlag: ImageView
        init {
            tvtotalCases = itemView.findViewById(R.id.tvTotalCases)
            tvCountryName = itemView.findViewById(R.id.tvCountryNames)
            imgCountryFlag = itemView.findViewById(R.id.imgFlag)
        }
    }


    // method for filtering our recyclerview items.
    fun filterList(filterllist: MutableList<CovidCountry>) {
        // below line is to add our filtered
        // list in our course array list.
        countryList = filterllist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }


}


