package com.example.diaryinmyhand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.diaryinmyhand.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var linearLayout: LinearLayout = findViewById(R.id.list)
        for (i in 1 .. 10) {
            val view: View = layoutInflater.inflate(R.layout.diaryitem,null)
            val tvItem: TextView = view.findViewById(R.id.item_title)
            tvItem.setText(""+ i +"번째 다이어리")
            linearLayout.addView(view)
        }


//        val DiaryList = ArrayList<DiaryForList>()
//        for(i in 0 until 10) {
//            DiaryList.add(DiaryForList(""+ i +"번째 일기"))
//        }
//
//        val container = binding.list
//        val inflater = LayoutInflater.from(this@MainActivity2)
//
//        for(i in 0 until DiaryList.size) {
//            val itemView = inflater.inflate(R.layout.diaryitem, null)
//            val diaryTime = itemView.findViewById<TextView>(R.id.item_title)
//            diaryTime.text = DiaryList.get(i).time
//            container.addView(itemView)
//        }


        binding.Settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.Calendar.setOnClickListener {
            val intent1 = Intent(this, CalendarActivity::class.java)
            startActivity(intent1)
        }

        binding.Plus.setOnClickListener {
            val intent2 = Intent(this, DiaryWriting::class.java)
            startActivity(intent2)
        }

    }
}

//class DiaryForList(val time:String) {
//
//}