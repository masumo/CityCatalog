package com.example.citycatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.citycatalog.R
import com.example.citycatalog.model.TravelLocationModel
import kotlinx.android.synthetic.main.card_container_location.view.*

class ViewPagerAdapterHawaii(
    private val features: List<TravelLocationModel>
) : RecyclerView.Adapter<ViewPagerAdapterHawaii.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val kbvLocation: ImageView = itemView.kbvLocation
        val textTitle: TextView = itemView.textTitle
        val textLocation: TextView = itemView.textLocation
        val textStarRating: TextView = itemView.textStarRating


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_container_location, parent, false)
        return ViewPagerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return features.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentItem = features[position]
        holder.textTitle.text = currentItem.title
        holder.textLocation.text = currentItem.location
        holder.textStarRating.text = currentItem.starRating.toString()

        Glide.with(holder.itemView.context)
            .load(currentItem.imageUrl)
            .fitCenter()
            .into(holder.kbvLocation)
    }

}