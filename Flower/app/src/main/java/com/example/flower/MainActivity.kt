package com.example.flower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Class 1", "핸드타이드", R.drawable.flower,"스파이럴 기법으로 만든 핸드타이드 꽃다발kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"))
        arrayList.add(Model("Class 2", "바스켓디자인", R.drawable.flower,""))
        arrayList.add(Model("Class 3", "캔들리스", R.drawable.flower,""))
        arrayList.add(Model("Class 4", "가드닝", R.drawable.flower,"과연 들어갈까"))
        arrayList.add(Model("Class 5", "부케", R.drawable.flower,"과연 들어갈까"))
        arrayList.add(Model("Class 6", "베이스어레인지먼트", R.drawable.flower,"과연 들어갈까"))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
    }
}