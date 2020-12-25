package com.example.android6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        // Context는 형으로 작동
        // this는 해당 클래스를 지칭
        val context: Context=this

        val applicationContext = applicationContext
    }
}