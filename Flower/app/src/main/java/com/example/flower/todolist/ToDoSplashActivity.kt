package com.example.flower.todolist

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.flower.R
import kotlinx.android.synthetic.main.activity_to_do_splash.*

class ToDoSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_splash)

        ic_logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in))
        Handler().postDelayed({
            ic_logo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_out))
            Handler().postDelayed({
                ic_logo.visibility = View.GONE      //로고를 숨기고 액티비티를 시작할게
                startActivity(Intent(this,ToDoMainActivity::class.java))
                finish()      //뒤로가기를 해도 splash가 다시 실행되지 않도록
            },500)
        },1500)     //Handler를 사용하여 1.5초 후에 종료 애니메이션 시작
    }
}