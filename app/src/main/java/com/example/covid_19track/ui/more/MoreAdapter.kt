package com.example.covid_19track.ui.more

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19track.R
import com.example.covid_19track.ui.more.MoreAdapter.MoreVH
import org.jetbrains.annotations.NotNull

class MoreAdapter(var context: Context?, var moreModelList: List<MoreModel>) :
    RecyclerView.Adapter<MoreVH>() {
    var lastPosition = -1
    @NotNull
    override fun onCreateViewHolder(@NotNull parent: ViewGroup, viewType: Int): MoreVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.more_item_layout, parent, false)
        return MoreVH(view)
    }

    override fun onBindViewHolder(@NotNull holder: MoreVH, position: Int) {
        val moreModel = moreModelList[position]
        holder.imageView.setImageResource(moreModel.imageId)
        holder.textView.text = moreModel.symptom_name
        if (lastPosition < position) {
            val animation = AnimationUtils.loadAnimation(
                holder.itemView.context,
                R.anim.item_animation_fall_down
            )
            holder.itemView.animation = animation
            lastPosition = position
        }
    }

    override fun getItemCount(): Int {
        return moreModelList.size
    }

    inner class MoreVH(@NotNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView

        init {
            imageView = itemView.findViewById(R.id.symptomImage)
            textView = itemView.findViewById(R.id.tvSymName)
        }
    }
}