package com.example.flowerintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView: ImageView = findViewById(R.id.img_detail)
        val name = findViewById<TextView>(R.id.tv_name_detail)
        val description = findViewById<TextView>(R.id.textView3)
        val elevation = findViewById<TextView>(R.id.flower_kind_detail)
        val country = findViewById<TextView>(R.id.time)

    }
}