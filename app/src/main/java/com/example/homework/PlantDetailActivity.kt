package com.example.homework

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.homework.databinding.ActivityPlantDetailBinding

class PlantDetailActivity : AppCompatActivity() {

    companion object{
        const val PLANT_FAMILY_NAME = "familyName"
        const val PLANT_NAME = "plantName"
        const val PLANT_SCIENTIFIC_NAME = "scientificName"
        const val PLANT_INFO = "plantInfo"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityPlantDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_plant_detail)

        val familyName = intent.getStringExtra(PLANT_FAMILY_NAME)
        val plantName = intent.getStringExtra(PLANT_NAME)
        val scientificName = intent.getStringExtra(PLANT_SCIENTIFIC_NAME)
        val plantInfo = intent.getStringExtra(PLANT_INFO)

        binding.familyNameView.text = familyName
        binding.plantNameView.text = plantName
        binding.scientificNameView.text = scientificName
        binding.plantInfoView.text = plantInfo

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}