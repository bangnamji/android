package com.example.flower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        actionBar.setTitle("Flower Class")


        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Class 1", "핸드타이드", R.drawable.real))
        arrayList.add(Model("Class 2", "바스켓디자인", R.drawable.real))
        arrayList.add(Model("Class 3", "캔들리스", R.drawable.real))
        arrayList.add(Model("Class 4", "가드닝", R.drawable.real))
        arrayList.add(Model("Class 5", "부케", R.drawable.real))
        arrayList.add(Model("Class 6", "베이스어레인지먼트", R.drawable.real))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
    }
}