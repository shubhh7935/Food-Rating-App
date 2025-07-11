package com.example.foodratingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val foodList = listOf(
        Triple(R.id.foodName1, R.id.ratingBar1, R.id.btnRate1),
        Triple(R.id.foodName2, R.id.ratingBar2, R.id.btnRate2),
        Triple(R.id.foodName3, R.id.ratingBar3, R.id.btnRate3),
        Triple(R.id.foodName4, R.id.ratingBar4, R.id.btnRate4),
        Triple(R.id.foodName5, R.id.ratingBar5, R.id.btnRate5),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for ((foodNameId, ratingBarId, buttonId) in foodList) {
            val foodName = findViewById<TextView>(foodNameId)
            val ratingBar = findViewById<RatingBar>(ratingBarId)
            val rateBtn = findViewById<Button>(buttonId)

            rateBtn.setOnClickListener {
                val rating = ratingBar.rating
                showCustomToast("${foodName.text} rated $rating ★")
            }
        }

    }

    private fun showCustomToast(message: String) {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toastRoot))

        val toastText = layout.findViewById<TextView>(R.id.toastText)
        toastText.text = message

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}