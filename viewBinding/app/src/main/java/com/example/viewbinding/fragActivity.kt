package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.viewbinding.databinding.ActivityFragBinding


class fragActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.frag1.setOnClickListener {
            val fragmentOne:FragmentOne=FragmentOne()
            val fragmentManager:FragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }

        binding.frag2.setOnClickListener {
            val fragmentOne:FragmentOne =FragmentOne()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.commit()

        }
    }
}