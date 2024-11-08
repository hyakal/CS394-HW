package com.example.homework.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.PlantDetailActivity
import com.example.homework.R
import com.example.homework.model.Plant

class ItemAdapter(private val data: List<Plant>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        private lateinit var plant: Plant

        val familyNameTV: TextView = view.findViewById(R.id.familyNameTV)
        val plantNameTV: TextView = view.findViewById(R.id.plantNameTV)

        init {
            view.setOnClickListener {
                val context = itemView.context
                val showPlantIntent = Intent(context, PlantDetailActivity::class.java)
                showPlantIntent.putExtra(PlantDetailActivity.PLANT_FAMILY_NAME, plant.familyName)
                showPlantIntent.putExtra(PlantDetailActivity.PLANT_NAME, plant.plantName)
                showPlantIntent.putExtra(PlantDetailActivity.PLANT_SCIENTIFIC_NAME, plant.scientificName)
                showPlantIntent.putExtra(PlantDetailActivity.PLANT_INFO, plant.plantInfo)
                context.startActivity(showPlantIntent)
            }
        }

        fun bind(plant: Plant) {
            this.plant = plant
            familyNameTV.text = plant.familyName
            plantNameTV.text = plant.plantName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val plant = data[position]
        holder.bind(plant)
    }
}