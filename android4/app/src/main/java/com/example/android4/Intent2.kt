package com.example.android4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android4.databinding.ActivityIntent1Binding

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //build.grandle에서 바인딩을 sync now하면 MainActivity -> ActivityMainBinding으로 '반전'
        val binding= ActivityIntent1Binding.inflate(layoutInflater)

        //뷰 바인딩과 연결
        setContentView(binding.root)
//        setContentView(R.layout.activity_intent2)
    }
}