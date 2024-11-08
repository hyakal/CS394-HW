package com.example.homework.data

import android.content.Context
import com.example.homework.R
import com.example.homework.model.Plant

class DataSource(val context: Context) {
    fun getPlantFamilyList(): Array<String> {
        return context.resources.getStringArray(R.array.family_name_array)
    }

    fun getPlantNameList(): Array<String> {
        return context.resources.getStringArray(R.array.plant_name_array)
    }

    fun getPlantScientificNameList(): Array<String> {
        return context.resources.getStringArray(R.array.plant_scientific_name_array)
    }

    fun getPlantInfoList(): Array<String> {
        return context.resources.getStringArray(R.array.plant_info_array)
    }


    fun LoadPlants(): List<Plant>{
        val plantFamilyList = getPlantFamilyList()
        val plantNameList = getPlantNameList()
        val plantScientificNameList = getPlantScientificNameList()
        val plantInfoList = getPlantInfoList()

        val plants = mutableListOf<Plant>()
        for (i in plantFamilyList.indices) {
            val plant = Plant(plantFamilyList[i], plantNameList[i], plantScientificNameList[i], plantInfoList[i])
            plants.add(plant)
        }
        return plants
    }
}