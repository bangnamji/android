package com.example.android7.ToDoList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.android7.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ic_logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in))
        Handler().postDelayed({
            ic_logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_out))
            Handler().postDelayed({
                ic_logo.visibility = View.GONE      //로고를 숨기고 액티비티를 시작할게
                startActivity(Intent(this,DashboardActivity::class.java))
                finish()      //뒤로가기를 해도 splash가 다시 실행되지 않도록
            },500)
        },1500)     //Handler를 사용하여 1.5초 후에 종료 애니메이션 시작
    }
}