package com.example.project

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.project.databinding.ActivityModifyBinding

class Modify : AppCompatActivity() {

    // 전역변수로 선언했어~
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private lateinit var binding: ActivityModifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply {
            val detail = getString("DETAIL","")
            binding.detailEdit.setText(detail)
        }
//        loadData()
//
//        binding.btnSave.setOnClickListener {
//            saveData()
//        }
    }

    fun saveData(v:View) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putString("DETAIL", binding.detailEdit.text.toString()).apply()

        val toast = Toast.makeText(applicationContext, "저장되었습니다!", Toast.LENGTH_LONG)
        toast.show()
    }


    fun clearData(v:View) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.clear().apply()

        binding.detailEdit.setText("")

        val toast = Toast.makeText(applicationContext, "삭제되었습니다.", Toast.LENGTH_LONG)
        toast.show()
    }

//    private fun saveData() {
//        val insertedText = binding.detailEdit.text.toString()
//        binding.editTitle.text = insertedText
//
//        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.apply {
//            putString("STRING_KEY", insertedText)
//        }.apply()
//
//        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
//    }

//    private fun loadData() {
//        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        val savedString = sharedPreferences.getString("STRING_KEY", null)
//
//        binding.editTitle.text = savedString
//    }

}



