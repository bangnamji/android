package com.example.android6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

//        fun plus(a:Int,b:Int?):Int{
//            if(b != null) return a + b
//            else return a
//        }
//
//        fun plus2(a:Int,b:Int?):Int?
//        {
//            return b?.plus(a)
//        }
        // 위에랑 밑에랑 같은 코드!

        val number:Int =10

        val number1:Int? = null
        val number3 = number1?.plus(number)

        Log.d("number","number3 :"+ number3)
    }
    //2020-12-25 17:57:29.419 23604-23604/com.example.android6 D/number: number3 :null


}