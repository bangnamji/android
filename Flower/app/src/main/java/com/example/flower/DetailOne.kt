package com.example.flower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.row.view.*

class DetailOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_one)

//        val actionBar : ActionBar? = supportActionBar
//        actionBar!!.setDisplayHomeAsUpEnabled(true)
//        actionBar!!.setDisplayShowHomeEnabled(true)
//
//
////        // getExtra
////        var intent = intent
////        val aTitle = intent.getStringExtra("iTitle")
////        val aImageView = intent.getIntExtra("iImageView",0)
////        val aDetail = intent.getStringExtra("iDetail")
//
//
//        actionBar.setTitle(aTitle)
//        name_detail.text = aTitle
//        textView3.text = aDetail
//        img_detail.setImageResource(aImageView)


    }
}