package com.example.project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityMainBinding
import com.example.project.databinding.ActivityTodoSplashBinding


//class MainActivity : AppCompatActivity() {
//    private val data = ArrayList<TodoList>()
//
//    private lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)


class todo_Splash : AppCompatActivity() {

    private lateinit var binding: ActivityTodoSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTodoSplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.icLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in))
        Handler().postDelayed({
            binding.icLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_out))
            Handler().postDelayed({
                binding.icLogo.visibility = View.GONE      //로고를 숨기고 액티비티를 시작할게
                startActivity(Intent(this,CheckBoxActivity::class.java))
                finish()      //뒤로가기를 해도 splash가 다시 실행되지 않도록
            },500)
        },1500)     //Handler를 사용하여 1.5초 후에 종료 애니메이션 시작
    }
}