package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.fragment2.FragmentOne
import com.example.fragment2.R
import com.example.fragment2.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentOne:FragmentOne = FragmentOne()

        binding.out.setOnClickListener{

            val fragmentManager: FragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragmentOne)
            fragmentTransaction.commit()
        }

    }
}