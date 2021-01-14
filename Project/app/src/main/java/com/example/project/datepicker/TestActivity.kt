package com.example.project.datepicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.tvClick.setOnClickListener {
            val intent = Intent(this, DatePicker_1::class.java)
            this.startActivity(intent)      //상세페이지로 intent...
        }
    }
}