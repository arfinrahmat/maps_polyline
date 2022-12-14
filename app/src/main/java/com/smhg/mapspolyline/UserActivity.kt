package com.smhg.mapspolyline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smhg.mapspolyline.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    var counter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounter.setOnClickListener {
            counter += 1
            binding.textCounter.text = "$counter"

            println("----COUNTER -> $counter ----")
        }
    }
}