package com.example.fragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.fragment2.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}