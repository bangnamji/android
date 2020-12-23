package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.android4.databinding.ActivityIntent1Binding
import android.content.Intent
import android.util.Log
import com.example.android4.Intent2

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //build.grandle에서 바인딩을 sync now하면 MainActivity -> ActivityMainBinding으로 '반전'
        val binding=ActivityIntent1Binding.inflate(layoutInflater)

        //뷰 바인딩과 연결
        setContentView(binding.root)
//        setContentView(R.layout.activity_intent1)

        binding.change.setOnClickListener {
            val intent=Intent(this@Intent1, Intent2::class.java)
            intent.apply{
                this.putExtra("number1",1)
                this.putExtra("number2",2)
            }

            startActivityForResult(intent,200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200){
            Log.d("number","" +requestCode)
            Log.d("number","" +resultCode)
            val result=data?.getIntExtra("result",0)
            Log.d("number",""+result)

        }

    }
}
}

