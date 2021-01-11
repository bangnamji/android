package com.example.project.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.R
import com.example.project.databinding.ActivityGalleryMainBinding

class GalleryMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}