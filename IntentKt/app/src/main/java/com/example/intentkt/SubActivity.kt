package com.example.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // msg라는 객체가 가지고 있으면 {} 내부를 실행해줘
        if(intent.hasExtra("msg")){

            // 서브 액티비티의 존재하는 텍스트뷰에다가 HelloWorld가 넘겨져 옴옴
           tv_getMsg.text = intent.getStringExtra("msg") // MainActivity에서 toString() 했으니깐 getStringExtra로 받는 것 + settext == text
        }

    }
}