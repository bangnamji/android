package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
            User(R.drawable.android, "최종헌","28","ENFJ"),
            User(R.drawable.android, "방남지","24","ENTJ"),
            User(R.drawable.android, "정승훈","24","ENFJ"),
            User(R.drawable.android, "한상민","23","????"),
            User(R.drawable.android, "고희정","22","ISFJ"),
            User(R.drawable.android, "유수안","22","ISFP"),
            User(R.drawable.android, "김해린","20","INFP"),
            User(R.drawable.android, "권우정","20","INFJ")

    )

    override fun onCreate(savedInstanceState: Bundle?) {    // 액티비티의 실행 시작 지점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val item = arrayOf("사과","배","딸기","키위","StartUF")
//
//        // context란 한 액티비티의 모든 정보를 담고있다.
//        listView.adapter=ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        listView.adapter = Adapter

        // 클릭하여 toast message까지 띄워보자.
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val selecItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selecItem.greet, Toast.LENGTH_SHORT).show()

        }

    }
}