package com.example.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_a.setOnClickListener{
            // var : 변수 값이 언제든지 변경 될 수 있음.
            // val : 자바에서는 final 값이 변경되지 못하는 변수.

            val intent=Intent(this, SubActivity::class.java) // 다음 화면으로 이동하기 위한 인텐트 객체 생성

            // HelloWorld라는 텍스트 값을 담은 뒤 msg라는 키로 잠궜다. -> SubActivity로 넘어가야함
            intent.putExtra("msg", tv_sendMsg.text.toString()) // putExtra(id값, 실제 넘길 값)

            startActivity(intent)
            finish() // 인텐트 실행 후 자기 자신 엑티비티를 제거한다.
        }
    }
}